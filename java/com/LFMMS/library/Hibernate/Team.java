package com.LFMMS.library.Hibernate;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Team entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "team", schema = "public")
public class Team extends AbstractTeam implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Team() {

	}

	/** minimal constructor */
	public Team(String name, String home, String coach) {

		super(name, home, coach);
	}

	/** full constructor */
	public Team(String name, String home, String coach, Set<Course> coursesForHomeId,
			Set<Player> players, Set<TeamRank> teamRanks, Set<Course> coursesForAwayId) {

		super(name, home, coach, coursesForHomeId, players, teamRanks, coursesForAwayId);
	}

}
