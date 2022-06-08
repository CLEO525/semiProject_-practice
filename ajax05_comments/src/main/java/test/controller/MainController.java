package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MovieDao;
import test.vo.MovieVo;

@WebServlet("/main")
public class MainController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DB에서 영화정보(목록) 얻어와서 main.jsp에서 출력하기
		// DAO는 싱글톤객체로 만들어 보세요
		MovieDao dao = MovieDao.getInstance();
		ArrayList<MovieVo> list = dao.mList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
}
