package com.LFMMS.library.action.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;


public class PlayerShowAllAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		PlayerDAO playerDAO = new PlayerDAO();
		List<Player> result = playerDAO.findAll();

		ArrayList<Player> players = new ArrayList<Player>(result);
		HttpSession session = request.getSession();
		session.setAttribute("players", players);
	}

}
