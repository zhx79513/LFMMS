package com.LFMMS.library.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * TeamRank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "team_rank", schema = "public")
public class TeamRank extends AbstractTeamRank implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TeamRank() {

	}

	/** full constructor */
	public TeamRank(Team team, Short place, Short turn, Short win, Short even, Short lost,
			Short goal, Short lostGoal, Short netGoal, Short point) {

		super(team, place, turn, win, even, lost, goal, lostGoal, netGoal, point);
	}

}
