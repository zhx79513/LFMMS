package com.LFMMS.library.Hibernate;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * AbstractCourse entity provides the base persistence definition of the Course entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private Team teamByHomeId;
	private Team teamByAwayId;
	private Short turn;
	private Timestamp matchDate;
	private Short homeScore;
	private Short awayScore;
	private Set<Goal> goals = new HashSet<Goal>(0);

	// Constructors

	/** default constructor */
	public AbstractCourse() {

	}

	/** minimal constructor */
	public AbstractCourse(Team teamByHomeId, Team teamByAwayId, Short turn, Timestamp matchDate,
			Short homeScore, Short awayScore) {

		this.teamByHomeId = teamByHomeId;
		this.teamByAwayId = teamByAwayId;
		this.turn = turn;
		this.matchDate = matchDate;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
	}

	/** full constructor */
	public AbstractCourse(Team teamByHomeId, Team teamByAwayId, Short turn, Timestamp matchDate,
			Short homeScore, Short awayScore, Set<Goal> goals) {

		this.teamByHomeId = teamByHomeId;
		this.teamByAwayId = teamByAwayId;
		this.turn = turn;
		this.matchDate = matchDate;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.goals = goals;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_seq")
	@SequenceGenerator(name = "course_id_seq", sequenceName = "course_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "home_id", nullable = false)
	public Team getTeamByHomeId() {

		return this.teamByHomeId;
	}

	public void setTeamByHomeId(Team teamByHomeId) {

		this.teamByHomeId = teamByHomeId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "away_id", nullable = false)
	public Team getTeamByAwayId() {

		return this.teamByAwayId;
	}

	public void setTeamByAwayId(Team teamByAwayId) {

		this.teamByAwayId = teamByAwayId;
	}

	@Column(name = "turn", nullable = false)
	public Short getTurn() {

		return this.turn;
	}

	public void setTurn(Short turn) {

		this.turn = turn;
	}

	@Column(name = "match_date", nullable = false, length = 35)
	public Timestamp getMatchDate() {

		return this.matchDate;
	}

	public void setMatchDate(Timestamp matchDate) {

		this.matchDate = matchDate;
	}

	@Column(name = "home_score", nullable = false)
	public Short getHomeScore() {

		return this.homeScore;
	}

	public void setHomeScore(Short homeScore) {

		this.homeScore = homeScore;
	}

	@Column(name = "away_score", nullable = false)
	public Short getAwayScore() {

		return this.awayScore;
	}

	public void setAwayScore(Short awayScore) {

		this.awayScore = awayScore;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Goal> getGoals() {

		return this.goals;
	}

	public void setGoals(Set<Goal> goals) {

		this.goals = goals;
	}

}