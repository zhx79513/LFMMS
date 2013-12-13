package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Team;
import com.LFMMS.library.Hibernate.TeamDAO;
import com.LFMMS.library.action.Action;
import com.LFMMS.library.action.team.TeamAction;
import com.LFMMS.library.action.team.TeamAddAction;
import com.LFMMS.library.action.team.TeamDeleteAction;
import com.LFMMS.library.action.team.TeamModifyCommitAction;
import com.LFMMS.library.action.team.TeamModifyShowAction;
import com.LFMMS.library.action.team.TeamShowAction;

public class TeamManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamManage() {

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

		request.setCharacterEncoding("UTF-8");
		String strAction = request.getParameter("action");
		TeamAction action = null;
		
		if (strAction.equals("show")) {
			action = new TeamShowAction();	
		} else if (strAction.equals("add")) {
			action = new TeamAddAction();
		} else if (strAction.equals("delete")) {
			action = new TeamDeleteAction();
		} else if (strAction.equals("modify_show")) {
			action = new TeamModifyShowAction();
		} else if (strAction.equals("modify_commit")) {
			action = new TeamModifyCommitAction();
		} else {
			throw new ServletException("Invalid action: " + strAction);
		}
		
		action.doAction(request, response);
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
