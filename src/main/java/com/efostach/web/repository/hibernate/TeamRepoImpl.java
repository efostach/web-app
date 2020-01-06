package com.efostach.web.repository.hibernate;

import com.efostach.web.model.Team;
import com.efostach.web.repository.TeamRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.web.repository.hibernate.HibernateUtil.getSessionFactory;


public class TeamRepoImpl implements TeamRepository {

    public Team getById(Integer id){
        Session session = getSessionFactory().openSession();
        Team team = session.get(Team.class, id);

        session.close();
        return team;
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
