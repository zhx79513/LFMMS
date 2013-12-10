package com.LFMMS.library.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * PlayerRank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "player_rank", schema = "public")
public class PlayerRank extends AbstractPlayerRank implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PlayerRank() {

	}

	/** full constructor */
	public PlayerRank(Player player, Short place, Short goal) {

		super(player, place, goal);
	}

}
