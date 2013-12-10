package com.LFMMS.library.Hibernate;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Player entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "player", schema = "public")
public class Player extends AbstractPlayer implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Player() {

	}

	/** minimal constructor */
	public Player(Team team, String name, Short number, Short position) {

		super(team, name, number, position);
	}

	/** full constructor */
	public Player(Team team, String name, Short number, Short position, Short height, Short weight,
			Date birthday, Set<PlayerRank> playerRanks, Set<Goal> goals) {

		super(team, name, number, position, height, weight, birthday, playerRanks, goals);
	}

}
