package com.efostach.web.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name="project_teams",
            joinColumns=@JoinColumn (name="team_id"),
            inverseJoinColumns=@JoinColumn(name="project_id"))
    private List<Employee> employees;

    public Team() {
    }

    public Team(Integer id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString(){
        return id + ", " + name + ", " + employees + "\n";
    }
}
