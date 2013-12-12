package com.LFMMS.library.action.player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;
import com.LFMMS.library.action.Action;


public class PlayerDeleteAction implements Action {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String playerId = request.getParameter("player_id");
		PlayerDAO playerDAO = new PlayerDAO();
		Transaction transaction = playerDAO.getSession().beginTransaction();

		try {
			Player player = playerDAO.findById(Integer.valueOf(playerId));
			playerDAO.delete(player);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		response.sendRedirect("PlayerManage?action=show");
	}

}
