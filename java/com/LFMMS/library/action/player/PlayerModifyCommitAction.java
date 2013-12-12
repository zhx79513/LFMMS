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


public class PlayerModifyCommitAction extends PlayerAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
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
			Player player = playerDAO.findById(Integer.valueOf(id));
			player.setName(name);
			Team team = teamDAO.findById(Integer.valueOf(teamId));
			player.setTeam(team);
			player.setNumber(Short.valueOf(number));
			player.setPosition(Short.valueOf(position));

			if (!height.equalsIgnoreCase("null") && !height.isEmpty())
				player.setHeight(Short.valueOf(height));

			if (!weight.equalsIgnoreCase("null") && !weight.isEmpty())
				player.setWeight(Short.valueOf(weight));

			if (!birthday.equalsIgnoreCase("null") && !birthday.isEmpty()) {
				Date date = DateFormat.getDateInstance().parse(birthday);
				long time = date.getTime();
				Timestamp ts = new Timestamp(time);
				player.setBirthday(ts);
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		response.sendRedirect("PlayerManage?action=show");
	}

}
