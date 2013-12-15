package com.LFMMS.library.action.Course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;


public class CourseShowByIdAction extends CourseAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		CourseDAO dao = new CourseDAO();
		String courseId = request.getParameter("course_id");
		Course course = dao.findById(Integer.valueOf(courseId));
		HttpSession session = request.getSession();
		session.setAttribute("course", course);
	}

}
