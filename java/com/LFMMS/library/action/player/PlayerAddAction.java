package com.LFMMS.library.action.player;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;
import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;


public class PlayerAddAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String teamId = request.getParameter("team_id");
		String number = request.getParameter("number");
		String position = request.getParameter("position");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String birthday = request.getParameter("birthday");

		PlayerDAO playerDAO = new PlayerDAO();
		TeamDAO teamDAO = new TeamDAO();

		Transaction transaction = playerDAO.getSession().beginTransaction();

		try {
			Team team = teamDAO.findById(Integer.valueOf(teamId));
			Player player = new Player(team, name, Short.valueOf(number), Short.valueOf(position));

			if (height != null && !height.isEmpty()) {
				player.setHeight(Short.valueOf(height));
			}

			if (weight != null && !weight.isEmpty()) {
				player.setWeight(Short.valueOf(weight));
			}

			if (birthday != null && !birthday.isEmpty()) {
				Date date = DateFormat.getDateInstance().parse(birthday);
				long time = date.getTime();
				Timestamp ts = new Timestamp(time);
				player.setBirthday(ts);
			}

			playerDAO.save(player);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		response.sendRedirect("PlayerManage?action=show");
	}

}
