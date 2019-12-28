package com.efostach.clientserver.repository;

import com.efostach.hibernate.model.Team;

import java.util.List;

public interface TeamRepository extends GenericRpository<Team, Integer> {

    List<Team> getBySkill(Integer skillId);
}
