package com.efostach.clientserver.repository;

import com.efostach.hibernate.model.Project;

import java.util.List;

public interface ProjectRepository extends GenericRpository<Project, Integer>  {

    List<Project> getByTeam(Integer teamId);

    List<Project> getByCost(Integer cost);

    List<Project> getBySkill(Integer skillId);

}