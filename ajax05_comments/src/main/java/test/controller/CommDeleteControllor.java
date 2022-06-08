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

@WebServlet("/comm/delete")
public class CommDeleteControllor extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		CommentsDao dao = CommentsDao.getInstance();
		int n = dao.delete(num);
		
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
