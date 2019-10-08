package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MovieDao;
import test.vo.MovieVo;
@WebServlet("/movie")
public class MovieController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		MovieDao dao=MovieDao.getMovieDao();
		MovieVo vo=dao.getinfo(mnum);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/movie.jsp").forward(req, resp);
	}
}











