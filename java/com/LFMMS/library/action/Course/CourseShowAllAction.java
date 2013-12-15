package com.LFMMS.library.action.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;


public class CourseShowAllAction extends CourseAction{

	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		CourseDAO dao = new CourseDAO();
		List<Course> result = dao.findAll();

		ArrayList<Course> courses = new ArrayList<Course>(result);
		HttpSession session = request.getSession();
		session.setAttribute("courses", courses);
	}

}
