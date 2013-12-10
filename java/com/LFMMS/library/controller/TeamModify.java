package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;

public class TeamModify extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamModify() {

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

		TeamDAO teamDAO = new TeamDAO();
		String teamId = request.getParameter("team_id");
		Team team = teamDAO.findById(Integer.valueOf(teamId));
		HttpSession session = request.getSession();
		session.setAttribute("team", team);
		response.sendRedirect("/LFMMS/team_modify.jsp");
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
