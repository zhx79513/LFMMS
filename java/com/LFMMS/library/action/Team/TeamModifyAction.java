package com.LFMMS.library.action.Team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class TeamModifyAction extends TeamAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String home = request.getParameter("home");
		String coach = request.getParameter("coach");

		TeamDAO teamDAO = new TeamDAO();
		Transaction transaction = teamDAO.getSession().beginTransaction();

		try {
			Team team = teamDAO.findById(Integer.valueOf(id));
			team.setName(name);
			team.setHome(home);
			team.setCoach(coach);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
