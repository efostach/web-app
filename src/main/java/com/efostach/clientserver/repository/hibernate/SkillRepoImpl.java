package com.efostach.clientserver.repository;

import com.efostach.hibernate.model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.hibernate.repository.hibernate.HibernateUtil.getSessionFactory;

public class SkillRepoImpl implements SkillRepository {

    public Skill getById(Integer id){
        Session session = getSessionFactory().openSession();
        Skill skill = session.get(Skill.class, id);

        session.close();
        return skill;
    }

    public List<Skill> getAll() {
        Session session = getSessionFactory().openSession();
        List skills = session.createQuery("FROM Skill").list();

        session.close();
        return (List<Skill>) skills;
    }

    public void create(Skill skill){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(skill);
        transaction.commit();
        session.close();
    }

    public void update(Skill skill) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(skill);
        transaction.commit();
        session.close();
    }

    public void delete(Skill skill) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(skill);
        transaction.commit();
        session.close();
    }
}
