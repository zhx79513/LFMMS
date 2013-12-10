package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Admin;
import com.LFMMS.library.Hibernate.AdminDAO;
import com.LFMMS.library.utility.MD5Util;


public class AdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 220096689040763716L;

	/**
	 * Constructor of the object.
	 */
	public AdminLogin() {

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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDAO adminDAO = new AdminDAO();
		List<Admin> result = adminDAO.findByUsername(username);
		
		if (result.size() == 1) {
			Admin admin = result.get(0);
			String passwdMD5 = MD5Util.MD5(password);
			HttpSession session = request.getSession();
			if (admin.getPassword().equalsIgnoreCase(passwdMD5)) {
				session.setAttribute("admin", admin);	
			}
			else {
				session.setAttribute("admin", null);
			}
		}
		
		response.sendRedirect("/LFMMS/index.jsp");
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
