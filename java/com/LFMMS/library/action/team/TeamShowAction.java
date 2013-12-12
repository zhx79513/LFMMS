package com.LFMMS.library.action.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class TeamShowAction extends TeamAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TeamDAO teamDAO = new TeamDAO();
		List<Team> result = teamDAO.findAll();

		ArrayList<Team> teams = new ArrayList<Team>();
		for (Team team : result) {
			teams.add(team);
		}

		HttpSession session = request.getSession();
		session.setAttribute("teams", teams);
		response.sendRedirect("/LFMMS/team_mng.jsp");
	}

}
