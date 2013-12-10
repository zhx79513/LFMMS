package com.LFMMS.library.action.course;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;
import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;
import com.LFMMS.library.action.Action;


public class CourseAddAction implements Action {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String homeId = request.getParameter("home_id");
		String awayId = request.getParameter("away_id");
		String turn = request.getParameter("turn");
		String date = request.getParameter("date");
		String homeScore = request.getParameter("home_score");
		String awayScore = request.getParameter("away_score");

		CourseDAO courseDAO = new CourseDAO();
		TeamDAO teamDAO = new TeamDAO();
		Transaction transaction = courseDAO.getSession().beginTransaction();

		try {
			Team homeTeam = teamDAO.findById(Integer.valueOf(homeId));
			Team awayTeam = teamDAO.findById(Integer.valueOf(awayId));
			Timestamp ts = Timestamp.valueOf(date);
			Course course = new Course(homeTeam, awayTeam, Short.valueOf(turn), ts,
					Short.valueOf(homeScore), Short.valueOf(awayScore));
			courseDAO.save(course);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		response.sendRedirect("MatchManage?action=show");
	}
}
