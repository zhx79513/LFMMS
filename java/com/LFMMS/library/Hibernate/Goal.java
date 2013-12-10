package com.LFMMS.library.Hibernate;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Goal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goal", schema = "public")
public class Goal extends AbstractGoal implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goal() {

	}

	/** full constructor */
	public Goal(Course course, Player player, Timestamp goalTime) {

		super(course, player, goalTime);
	}

}
