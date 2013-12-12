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


public class CourseModifyCommitAction extends CourseAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
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

		response.sendRedirect("MatchManage?action=show");
	}

}
