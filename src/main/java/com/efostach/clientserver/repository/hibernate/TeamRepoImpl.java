package com.efostach.clientserver.repository;

import com.efostach.hibernate.model.Team;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.hibernate.repository.hibernate.HibernateUtil.getSessionFactory;

public class TeamRepoImpl implements TeamRepository {

    public Team getById(Integer id){
        Session session = getSessionFactory().openSession();
        Team team = session.get(Team.class, id);

        session.close();
        return team;
    }

    public List<Team> getBySkill(Integer skillId) {
        Session session = getSessionFactory().openSession();
        List teams =  session.createQuery("FROM Team t WHERE t.id IN (SELECT DISTINCT e.teamId FROM Employee e LEFT JOIN e.skills es WHERE es.id = :skill_id)").setParameter("skill_id", skillId).list();

        session.close();
        return (List<Team>) teams;
    }

    public List<Team> getAll() {
        Session session = getSessionFactory().openSession();
        List teams = session.createQuery("FROM Team").list();

        session.close();
        return (List<Team>) teams;
    }

    public void create(Team team){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(team);
        transaction.commit();
        session.close();
    }

    public void update(Team team) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(team);
        transaction.commit();
        session.close();
    }

    public void delete(Team team) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(team);
        transaction.commit();
        session.close();
    }
}
