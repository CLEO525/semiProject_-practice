package test.controller;

import test.dao.MemberDao;
import test.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class JoinController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/member/join.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 사용자가 입력한 정보 읽어오기
        String id=req.getParameter("id");
        String pwd=req.getParameter("pwd");
        String email=req.getParameter("email");
        int age=Integer.parseInt(req.getParameter("age"));
        // 사용자 정보를 DB에 저장하기
        Member vo=new Member(id, pwd, email, age, null);
        MemberDao dao=new MemberDao();
        int n=dao.insert(vo);

        // 결과응답하기
        if(n>0) {
            req.setAttribute("result","success");
        }else {
            req.setAttribute("result","fail");
        }
        req.getRequestDispatcher("/member/result.jsp").forward(req, resp);
    }
}
