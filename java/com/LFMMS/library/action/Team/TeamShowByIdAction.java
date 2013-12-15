package com.LFMMS.library.action.Team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class TeamShowByIdAction extends TeamAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		TeamDAO teamDAO = new TeamDAO();
		String teamId = request.getParameter("team_id");
		Team team = teamDAO.findById(Integer.valueOf(teamId));
		HttpSession session = request.getSession();
		session.setAttribute("team", team);
	}

}
