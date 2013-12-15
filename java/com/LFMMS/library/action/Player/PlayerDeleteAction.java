package com.LFMMS.library.action.Player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;


public class PlayerDeleteAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request)
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
	}

}
