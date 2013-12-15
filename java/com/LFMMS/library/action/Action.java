package com.LFMMS.library.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public interface Action {

	public void doAction(HttpServletRequest request)
			throws ServletException, IOException;
}
