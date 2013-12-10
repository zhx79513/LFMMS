package com.LFMMS.library.Hibernate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * AbstractAdmin entity provides the base persistence definition of the Admin entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public AbstractAdmin() {

	}

	/** full constructor */
	public AbstractAdmin(String username, String password) {

		this.username = username;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 32)
	public String getUsername() {

		return this.username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

}