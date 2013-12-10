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
 * AbstractTeamRank entity provides the base persistence definition of the TeamRank entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractTeamRank implements java.io.Serializable {

	// Fields

	private Integer id;
	private Team team;
	private Short place;
	private Short turn;
	private Short win;
	private Short even;
	private Short lost;
	private Short goal;
	private Short lostGoal;
	private Short netGoal;
	private Short point;

	// Constructors

	/** default constructor */
	public AbstractTeamRank() {

	}

	/** full constructor */
	public AbstractTeamRank(Team team, Short place, Short turn, Short win, Short even, Short lost,
			Short goal, Short lostGoal, Short netGoal, Short point) {

		this.team = team;
		this.place = place;
		this.turn = turn;
		this.win = win;
		this.even = even;
		this.lost = lost;
		this.goal = goal;
		this.lostGoal = lostGoal;
		this.netGoal = netGoal;
		this.point = point;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_rank_id_seq")
	@SequenceGenerator(name = "team_rank_id_seq", sequenceName = "team_rank_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	public Team getTeam() {

		return this.team;
	}

	public void setTeam(Team team) {

		this.team = team;
	}

	@Column(name = "place", nullable = false)
	public Short getPlace() {

		return this.place;
	}

	public void setPlace(Short place) {

		this.place = place;
	}

	@Column(name = "turn", nullable = false)
	public Short getTurn() {

		return this.turn;
	}

	public void setTurn(Short turn) {

		this.turn = turn;
	}

	@Column(name = "win", nullable = false)
	public Short getWin() {

		return this.win;
	}

	public void setWin(Short win) {

		this.win = win;
	}

	@Column(name = "even", nullable = false)
	public Short getEven() {

		return this.even;
	}

	public void setEven(Short even) {

		this.even = even;
	}

	@Column(name = "lost", nullable = false)
	public Short getLost() {

		return this.lost;
	}

	public void setLost(Short lost) {

		this.lost = lost;
	}

	@Column(name = "goal", nullable = false)
	public Short getGoal() {

		return this.goal;
	}

	public void setGoal(Short goal) {

		this.goal = goal;
	}

	@Column(name = "lost_goal", nullable = false)
	public Short getLostGoal() {

		return this.lostGoal;
	}

	public void setLostGoal(Short lostGoal) {

		this.lostGoal = lostGoal;
	}

	@Column(name = "net_goal", nullable = false)
	public Short getNetGoal() {

		return this.netGoal;
	}

	public void setNetGoal(Short netGoal) {

		this.netGoal = netGoal;
	}

	@Column(name = "point", nullable = false)
	public Short getPoint() {

		return this.point;
	}

	public void setPoint(Short point) {

		this.point = point;
	}

}