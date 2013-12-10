package com.LFMMS.library.Hibernate;

import java.sql.Timestamp;
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
 * AbstractGoal entity provides the base persistence definition of the Goal entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractGoal implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private Player player;
	private Timestamp goalTime;

	// Constructors

	/** default constructor */
	public AbstractGoal() {

	}

	/** full constructor */
	public AbstractGoal(Course course, Player player, Timestamp goalTime) {

		this.course = course;
		this.player = player;
		this.goalTime = goalTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goal_id_seq")
	@SequenceGenerator(name = "goal_id_seq", sequenceName = "goal_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	public Course getCourse() {

		return this.course;
	}

	public void setCourse(Course course) {

		this.course = course;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", nullable = false)
	public Player getPlayer() {

		return this.player;
	}

	public void setPlayer(Player player) {

		this.player = player;
	}

	@Column(name = "goal_time", nullable = false, length = 35)
	public Timestamp getGoalTime() {

		return this.goalTime;
	}

	public void setGoalTime(Timestamp goalTime) {

		this.goalTime = goalTime;
	}

}