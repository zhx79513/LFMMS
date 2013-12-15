package com.LFMMS.library.action.Team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class TeamDeleteAction extends TeamAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		String id = request.getParameter("team_id");
		TeamDAO teamDAO = new TeamDAO();
		Transaction transaction = teamDAO.getSession().beginTransaction();

		try {
			Team team = teamDAO.findById(Integer.valueOf(id));
			teamDAO.delete(team);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
