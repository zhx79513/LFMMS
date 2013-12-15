package com.LFMMS.library.action.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LFMMS.library.Hibernate.Admin;
import com.LFMMS.library.Hibernate.AdminDAO;
import com.LFMMS.library.utility.MD5Util;


public class AdminLoginAction extends AdminAction {

	@Override
	public void doAction(HttpServletRequest request)
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
			} else {
				session.setAttribute("admin", null);
			}
		}
	}

}
