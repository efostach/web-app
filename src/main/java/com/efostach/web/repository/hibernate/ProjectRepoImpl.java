package com.efostach.web.repository.hibernate;

import com.efostach.web.model.Project;
import com.efostach.web.model.ProjectStatus;
import com.efostach.web.repository.ProjectRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.web.repository.hibernate.HibernateUtil.getSessionFactory;

public class ProjectRepoImpl implements ProjectRepository {

    public Project getById(Integer id) {
        Session session = getSessionFactory().openSession();
        Project project = session.get(Project.class, id);

        session.close();
        return project;
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
        if (project.getStatus() == null) {
            project.setStatus(ProjectStatus.IN_PROGRESS);
        }
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
