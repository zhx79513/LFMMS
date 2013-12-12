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

import com.LFMMS.library.Hibernate.Player;
import com.LFMMS.library.Hibernate.PlayerDAO;
import com.LFMMS.library.action.Action;
import com.LFMMS.library.action.player.PlayerAction;
import com.LFMMS.library.action.player.PlayerAddAction;
import com.LFMMS.library.action.player.PlayerDeleteAction;
import com.LFMMS.library.action.player.PlayerModifyCommitAction;
import com.LFMMS.library.action.player.PlayerModifyShowAction;
import com.LFMMS.library.action.player.PlayerShowAction;

public class PlayerManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PlayerManage() {

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

		String strAction = request.getParameter("action");
		PlayerAction action = null;
		
		if (strAction.equals("show")) {
			action = new PlayerShowAction();
		} else if (strAction.equals("add")) {
			action = new PlayerAddAction();
		} else if (strAction.equals("delete")) {
			action = new PlayerDeleteAction();
		} else if (strAction.equals("modify_show")) {
			action = new PlayerModifyShowAction();
		} else if (strAction.equals("modify_commit")) {
			action = new PlayerModifyCommitAction();
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
