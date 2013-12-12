package com.LFMMS.library.action.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;
import com.LFMMS.library.action.Action;


public class PlayerShowAction implements Action {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlayerDAO playerDAO = new PlayerDAO();
		List<Player> result = playerDAO.findAll();

		ArrayList<Player> players = new ArrayList<Player>();
		for (Player player : result) {
			players.add(player);
		}

		HttpSession session = request.getSession();
		session.setAttribute("players", players);
		response.sendRedirect("/LFMMS/player_mng.jsp");
	}

}
