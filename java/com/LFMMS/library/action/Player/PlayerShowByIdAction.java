package com.LFMMS.library.action.Player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;


public class PlayerShowByIdAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		String playerId = request.getParameter("player_id");
		PlayerDAO playerDAO = new PlayerDAO();

		Player player = playerDAO.findById(Integer.valueOf(playerId));
		HttpSession session = request.getSession();
		session.setAttribute("player", player);
	}

}
