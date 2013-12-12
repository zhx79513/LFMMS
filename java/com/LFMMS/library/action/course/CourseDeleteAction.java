package com.LFMMS.library.action.course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.LFMMS.library.Hibernate.Course;
import com.LFMMS.library.Hibernate.CourseDAO;


public class CourseDeleteAction extends CourseAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String courseId = request.getParameter("course_id");
		CourseDAO courseDAO = new CourseDAO();
		Transaction transaction = courseDAO.getSession().beginTransaction();

		try {
			Course course = courseDAO.findById(Integer.valueOf(courseId));
			courseDAO.delete(course);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		response.sendRedirect("MatchManage?action=show");
	}

}
