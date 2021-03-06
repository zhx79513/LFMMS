package com.LFMMS.library.action.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class TeamShowAllAction extends TeamAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		TeamDAO teamDAO = new TeamDAO();
		List<Team> result = teamDAO.findAll();

		ArrayList<Team> teams = new ArrayList<Team>(result);
		HttpSession session = request.getSession();
		session.setAttribute("teams", teams);
	}

}
