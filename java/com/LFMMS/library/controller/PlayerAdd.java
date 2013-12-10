package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;
import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;

public class PlayerAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PlayerAdd() {

		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {

		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		response.sendRedirect("PlayerManage");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {

		// Put your code here
	}

}
