package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.dao.CommentsDao;
import test.vo.CommentsVo;

@WebServlet("/comm/list")
public class CommListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum = Integer.parseInt(req.getParameter("mnum"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		CommentsDao dao = CommentsDao.getInstance();
		int startRow = (pageNum-1)*5+1;
		int endRow=startRow+4;
		
		ArrayList<CommentsVo> list = dao.cList(mnum,startRow,endRow);
		int pageCount=(int)Math.ceil(dao.getCount(mnum)/5.0);
		int startPage=(pageNum-1)/5*5+1;
		int endPage=startPage+4;
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		JSONObject data = new JSONObject();
		JSONArray arr= new JSONArray();
		for(CommentsVo vo:list) {
			JSONObject ob = new JSONObject();
			ob.put("num",vo.getNum());
			ob.put("mnum",vo.getMnum());
			ob.put("id",vo.getId());
			ob.put("comments",vo.getComments());
			arr.put(ob);
		}
		data.put("list", arr);
		data.put("pageCount", pageCount);
		data.put("startPage", startPage);
		data.put("endPage", endPage);
		data.put("pageNum", pageNum);
		pw.print(data);
	}
}
