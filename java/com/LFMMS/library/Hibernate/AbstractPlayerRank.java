package com.LFMMS.library.Hibernate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


/**
 * AbstractPlayerRank entity provides the base persistence definition of the PlayerRank entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPlayerRank implements java.io.Serializable {

	// Fields

	private Integer id;
	private Player player;
	private Short place;
	private Short goal;

	// Constructors

	/** default constructor */
	public AbstractPlayerRank() {

	}

	/** full constructor */
	public AbstractPlayerRank(Player player, Short place, Short goal) {

		this.player = player;
		this.place = place;
		this.goal = goal;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_rank_id_seq")
	@SequenceGenerator(name = "player_rank_id_seq", sequenceName = "player_rank_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", nullable = false)
	public Player getPlayer() {

		return this.player;
	}

	public void setPlayer(Player player) {

		this.player = player;
	}

	@Column(name = "place", nullable = false)
	public Short getPlace() {

		return this.place;
	}

	public void setPlace(Short place) {

		this.place = place;
	}

	@Column(name = "goal", nullable = false)
	public Short getGoal() {

		return this.goal;
	}

	public void setGoal(Short goal) {

		this.goal = goal;
	}

}