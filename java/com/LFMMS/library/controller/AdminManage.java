package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LFMMS.library.action.Action;
import com.LFMMS.library.action.ActionFactory;
import com.LFMMS.library.action.Admin.AdminAction;
import com.LFMMS.library.action.Admin.AdminLoginAction;
import com.LFMMS.library.action.Admin.AdminLogoutAction;
import com.LFMMS.library.constant.CONSTANT;

public class AdminManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminManage() {

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
		String redirect = request.getParameter("redirect");
		// 
		
		ActionFactory factory = new ActionFactory("Admin", strAction);
		try {
			Action action = factory.getInstance();
			action.doAction(request);
			response.sendRedirect(redirect);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
