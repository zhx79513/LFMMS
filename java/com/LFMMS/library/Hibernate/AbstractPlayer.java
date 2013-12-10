package com.LFMMS.library.Hibernate;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * AbstractPlayer entity provides the base persistence definition of the Player entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPlayer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Team team;
	private String name;
	private Short number;
	private Short position;
	private Short height;
	private Short weight;
	private Date birthday;
	private Set<PlayerRank> playerRanks = new HashSet<PlayerRank>(0);
	private Set<Goal> goals = new HashSet<Goal>(0);

	// Constructors

	/** default constructor */
	public AbstractPlayer() {

	}

	/** minimal constructor */
	public AbstractPlayer(Team team, String name, Short number, Short position) {

		this.team = team;
		this.name = name;
		this.number = number;
		this.position = position;
	}

	/** full constructor */
	public AbstractPlayer(Team team, String name, Short number, Short position, Short height,
			Short weight, Date birthday, Set<PlayerRank> playerRanks, Set<Goal> goals) {

		this.team = team;
		this.name = name;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.playerRanks = playerRanks;
		this.goals = goals;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
	@SequenceGenerator(name = "player_id_seq", sequenceName = "player_id_seq")
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Column(name = "number", nullable = false)
	public Short getNumber() {

		return this.number;
	}

	public void setNumber(Short number) {

		this.number = number;
	}

	@Column(name = "position", nullable = false)
	public Short getPosition() {

		return this.position;
	}

	public void setPosition(Short position) {

		this.position = position;
	}

	@Column(name = "height")
	public Short getHeight() {

		return this.height;
	}

	public void setHeight(Short height) {

		this.height = height;
	}

	@Column(name = "weight")
	public Short getWeight() {

		return this.weight;
	}

	public void setWeight(Short weight) {

		this.weight = weight;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 13)
	public Date getBirthday() {

		return this.birthday;
	}

	public void setBirthday(Date birthday) {

		this.birthday = birthday;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "player")
	public Set<PlayerRank> getPlayerRanks() {

		return this.playerRanks;
	}

	public void setPlayerRanks(Set<PlayerRank> playerRanks) {

		this.playerRanks = playerRanks;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "player")
	public Set<Goal> getGoals() {

		return this.goals;
	}

	public void setGoals(Set<Goal> goals) {

		this.goals = goals;
	}

}