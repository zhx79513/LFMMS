package com.LFMMS.library.action.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class AdminLogoutAction extends AdminAction {

	@Override
	public void doAction(HttpServletRequest request)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("admin", null);
	}

}
