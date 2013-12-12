package com.LFMMS.library.action.player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;


public class PlayerModifyShowAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String playerId = request.getParameter("player_id");
		PlayerDAO playerDAO = new PlayerDAO();

		Player player = playerDAO.findById(Integer.valueOf(playerId));
		HttpSession session = request.getSession();
		session.setAttribute("player", player);
		response.sendRedirect("/LFMMS/player_modify.jsp");
	}

}
