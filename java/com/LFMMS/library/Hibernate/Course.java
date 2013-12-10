package com.LFMMS.library.Hibernate;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", schema = "public")
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {

	}

	/** minimal constructor */
	public Course(Team teamByHomeId, Team teamByAwayId, Short turn, Timestamp matchDate,
			Short homeScore, Short awayScore) {

		super(teamByHomeId, teamByAwayId, turn, matchDate, homeScore, awayScore);
	}

	/** full constructor */
	public Course(Team teamByHomeId, Team teamByAwayId, Short turn, Timestamp matchDate,
			Short homeScore, Short awayScore, Set<Goal> goals) {

		super(teamByHomeId, teamByAwayId, turn, matchDate, homeScore, awayScore, goals);
	}

}
