package test.controller;

import test.dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/list")
public class ListController extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String id=(String)session.getAttribute("id");
        if(id==null) { //로그인안한 사용자 - 로그인페이지로 이동
            resp.sendRedirect(req.getContextPath()+"/login");
        }else { //로그인한 사용자 - 목록페이지로 이동
            MemberDao dao=new MemberDao();
            req.setAttribute("list", dao.selectAll());
            req.getRequestDispatcher("/member/list.jsp").forward(req, resp);
        }
    }
}
