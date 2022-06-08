package test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import test.dao.CommentsDao;
import test.vo.CommentsVo;

@WebServlet("/comm/insert")
public class CommInsertController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		int mnum = Integer.parseInt(req.getParameter("mnum"));
		String comments = req.getParameter("comments");
		CommentsDao dao = CommentsDao.getInstance();
		int n = dao.insert(new CommentsVo(0, mnum, id, comments));
		
		//json으로 받아오기
		resp.setContentType("type/plain;charset=utf=8");
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		if(n>0) {
			json.put("code", "success");
		}else {
			json.put("code", "fail");
		}
	}
}
