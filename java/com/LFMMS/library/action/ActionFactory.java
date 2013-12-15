package com.LFMMS.library.action;



public class ActionFactory {

	private String type;
	private String action;

	public ActionFactory(String type, String action) {

		this.type = type;
		this.action = action;
	}

	public Action getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		String pack = this.getClass().getPackage().getName();
		String className = pack + "." + type + "." + type + action + "Action";
		Action a = (Action)Class.forName(className).newInstance();
		
		return a;
	}

}
