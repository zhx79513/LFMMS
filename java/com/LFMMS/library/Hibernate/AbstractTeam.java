package com.LFMMS.library.Hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * AbstractTeam entity provides the base persistence definition of the Team entity. @author
 * MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractTeam implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String home;
	private String coach;
	private Set<Course> coursesForHomeId = new HashSet<Course>(0);
	private Set<Player> players = new HashSet<Player>(0);
	private Set<TeamRank> teamRanks = new HashSet<TeamRank>(0);
	private Set<Course> coursesForAwayId = new HashSet<Course>(0);

	// Constructors

	/** default constructor */
	public AbstractTeam() {

	}

	/** minimal constructor */
	public AbstractTeam(String name, String home, String coach) {

		this.name = name;
		this.home = home;
		this.coach = coach;
	}

	/** full constructor */
	public AbstractTeam(String name, String home, String coach, Set<Course> coursesForHomeId,
			Set<Player> players, Set<TeamRank> teamRanks, Set<Course> coursesForAwayId) {

		this.name = name;
		this.home = home;
		this.coach = coach;
		this.coursesForHomeId = coursesForHomeId;
		this.players = players;
		this.teamRanks = teamRanks;
		this.coursesForAwayId = coursesForAwayId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
	@SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Column(name = "home", nullable = false, length = 30)
	public String getHome() {

		return this.home;
	}

	public void setHome(String home) {

		this.home = home;
	}

	@Column(name = "coach", nullable = false, length = 20)
	public String getCoach() {

		return this.coach;
	}

	public void setCoach(String coach) {

		this.coach = coach;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teamByHomeId")
	public Set<Course> getCoursesForHomeId() {

		return this.coursesForHomeId;
	}

	public void setCoursesForHomeId(Set<Course> coursesForHomeId) {

		this.coursesForHomeId = coursesForHomeId;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Player> getPlayers() {

		return this.players;
	}

	public void setPlayers(Set<Player> players) {

		this.players = players;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	public Set<TeamRank> getTeamRanks() {

		return this.teamRanks;
	}

	public void setTeamRanks(Set<TeamRank> teamRanks) {

		this.teamRanks = teamRanks;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teamByAwayId")
	public Set<Course> getCoursesForAwayId() {

		return this.coursesForAwayId;
	}

	public void setCoursesForAwayId(Set<Course> coursesForAwayId) {

		this.coursesForAwayId = coursesForAwayId;
	}

}