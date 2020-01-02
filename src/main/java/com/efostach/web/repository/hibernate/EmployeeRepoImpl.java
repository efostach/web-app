package com.efostach.clientserver.repository.hibernate;

import com.efostach.clientserver.model.Employee;
import com.efostach.clientserver.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.clientserver.repository.hibernate.HibernateUtil.getSessionFactory;

public class EmployeeRepoImpl implements EmployeeRepository {

    public Employee getById(Integer id){
        Session session = getSessionFactory().openSession();
        Employee employee = session.get(Employee.class, id);

        session.close();
        return employee;
    }

    public List<Employee> getAll() {
        Session session = getSessionFactory().openSession();
        List employees = session.createQuery("FROM Employee").list();

        session.close();
        return (List<Employee>) employees;
    }

    public void create(Employee employee){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();
        session.close();
    }

    public void update(Employee employee) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(employee);
        transaction.commit();
        session.close();
    }
}
