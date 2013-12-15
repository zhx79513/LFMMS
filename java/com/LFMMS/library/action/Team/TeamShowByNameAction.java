package com.LFMMS.library.action.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;
import com.LFMMS.library.action.Action;

public class TeamShowByNameAction implements Action {

	@Override
	public void doAction(HttpServletRequest request) throws ServletException, IOException {

		TeamDAO teamDAO = new TeamDAO();
		String teamName = request.getParameter("name");
		List<Team> result = teamDAO.findByName(teamName);
		ArrayList<Team> teams = new ArrayList<Team>(result);
		request.getSession().setAttribute("teams", teams);
	}

}
