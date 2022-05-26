package test.controller;

import test.dao.BoardDao;
import test.vo.BoardVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/insert")
public class InsertController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/board/insertForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String writer = req.getParameter("writer");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int num = 0;
        int ref = 0;
        int lev = 0;
        int step = 0;
        String snum = req.getParameter("num");
        if (snum != null && !snum.equals("")) { //답글인 경우
            num = Integer.parseInt(snum);
            ref = Integer.parseInt(req.getParameter("ref"));
            lev = Integer.parseInt(req.getParameter("lev"));
            step = Integer.parseInt(req.getParameter("step"));
        }
        BoardVo vo = new BoardVo(num, writer, title, content, ref, lev, step);
        BoardDao dao = new BoardDao();
        int n = dao.insert(vo);
        if (n > 0) {
            req.setAttribute("code", "success");
        } else {
            req.setAttribute("code", "fail");
        }
        req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
    }
}




