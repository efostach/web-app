package com.efostach.clientserver.repository;

import com.efostach.hibernate.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.hibernate.repository.hibernate.HibernateUtil.getSessionFactory;

public class ProjectRepoImpl implements ProjectRepository {

    public Project getById(Integer id) {
        Session session = getSessionFactory().openSession();
        Project project = session.get(Project.class, id);

        session.close();
        return project;
    }

    public List<Project> getByTeam(Integer teamId) {
        Session session = getSessionFactory().openSession();
        List projects = session.createQuery("FROM Project p LEFT JOIN FETCH p.teams t WHERE t.id =" + teamId).list();

        session.close();
        return (List<Project>) projects;
    }

    public List<Project> getBySkill(Integer skillId) {
        Session session = getSessionFactory().openSession();
        List projects = session.createQuery("SELECT DISTINCT p FROM Project p LEFT JOIN FETCH p.teams t WHERE t.id IN (SELECT DISTINCT e.teamId FROM Employee e LEFT JOIN e.skills es WHERE es.id = :skill_id) ORDER BY p.id").setParameter("skill_id", skillId).list();

        session.close();
        return (List<Project>) projects;
    }

    public List<Project> getByCost(Integer cost) {
        Session session = getSessionFactory().openSession();
        List projects = session.createQuery("FROM Project p WHERE p.cost = " + cost).list();

        session.close();
        return (List<Project>) projects;
    }

    public List<Project> getAll() {
        Session session = getSessionFactory().openSession();
        List projects = session.createQuery("FROM Project").list();

        session.close();
        return (List<Project>) projects;
    }

    public void create(Project project) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(project);
        transaction.commit();
        session.close();
    }

    public void update(Project project) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(project);
        transaction.commit();
        session.close();
    }

    public void delete(Project project) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(project);
        transaction.commit();
        session.close();
    }
}
