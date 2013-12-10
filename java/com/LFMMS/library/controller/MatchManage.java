package com.LFMMS.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;
import com.LFMMS.library.action.Action;
import com.LFMMS.library.action.course.CourseAddAction;
import com.LFMMS.library.action.course.CourseDeleteAction;
import com.LFMMS.library.action.course.CourseModifyCommitAction;
import com.LFMMS.library.action.course.CourseModifyShowAction;
import com.LFMMS.library.action.course.CourseShowAction;


public class MatchManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MatchManage() {

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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strAction = request.getParameter("action");
		Action action = null;

		if (strAction.equals("show")) {
			action = new CourseShowAction();
		} else if (strAction.equals("add")) {
			action = new CourseAddAction();
		} else if (strAction.equals("delete")) {
			action = new CourseDeleteAction();
		} else if (strAction.equals("modify_show")) {
			action = new CourseModifyShowAction();
		} else if (strAction.equals("modify_commit")) {
			action = new CourseModifyCommitAction();
		} else {
			throw new ServletException("Invalid action: " + strAction);
		}

		action.doAction(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {

		// Put your code here
	}

}
