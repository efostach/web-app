package com.efostach.web.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "budget")
    private Integer budget;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="status", nullable = false)
    private ProjectStatus status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name="project_teams",
            joinColumns=@JoinColumn (name="project_id"),
            inverseJoinColumns=@JoinColumn(name="team_id"))
    private List<Team> teams;

    public Project() {
    }

    public Project(Integer id, String name, Integer budget, ProjectStatus status, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.status = status;
        this.teams = teams;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString(){
        return id + ", " + name + ", " + budget + ", " + status + "\n";
    }
}
