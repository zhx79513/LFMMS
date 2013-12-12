package com.LFMMS.library.action.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;


public class CourseShowAction extends CourseAction{

	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseDAO dao = new CourseDAO();
		List<Course> result = dao.findAll();

		ArrayList<Course> courses = new ArrayList<Course>();
		for (Course course : result) {
			courses.add(course);
		}

		HttpSession session = request.getSession();
		session.setAttribute("courses", courses);
		response.sendRedirect("/LFMMS/match_mng.jsp");
	}

}
