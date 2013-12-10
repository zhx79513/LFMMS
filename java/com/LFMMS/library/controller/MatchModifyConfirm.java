package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;
import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class MatchModifyConfirm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MatchModifyConfirm() {

		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {

		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String homeId = request.getParameter("home_id");
		String awayId = request.getParameter("away_id");
		String turn = request.getParameter("turn");
		String date = request.getParameter("date");
		String homeScore = request.getParameter("home_score");
		String awayScore = request.getParameter("away_score");

		CourseDAO courseDao = new CourseDAO();
		TeamDAO teamDAO = new TeamDAO();

		Transaction transaction = courseDao.getSession().beginTransaction();

		try {
			Course course = courseDao.findById(Integer.valueOf(id));
			Team homeTeam = teamDAO.findById(Integer.valueOf(homeId));
			course.setTeamByHomeId(homeTeam);
			Team awayTeam = teamDAO.findById(Integer.valueOf(awayId));
			course.setTeamByAwayId(awayTeam);
			course.setTurn(Short.valueOf(turn));
			Timestamp ts = Timestamp.valueOf(date);
			course.setMatchDate(ts);
			course.setHomeScore(Short.valueOf(homeScore));
			course.setAwayScore(Short.valueOf(awayScore));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		response.sendRedirect("MatchManage");
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {

		// Put your code here
	}

}
