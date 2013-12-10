package com.LFMMS.library.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin", schema = "public")
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Admin() {

	}

	/** full constructor */
	public Admin(String username, String password) {

		super(username, password);
	}

}
