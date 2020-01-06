package com.efostach.web.repository.hibernate;

import com.efostach.web.model.Customer;
import com.efostach.web.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.web.repository.hibernate.HibernateUtil.getSessionFactory;

public class CustomerRepoImpl implements CustomerRepository {

    public Customer getById(Integer id){
        Session session = getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);

        session.close();
        return customer;
    }

    public List<Customer> getAll() {
        Session session = getSessionFactory().openSession();
        List customers = session.createQuery("FROM Customer").list();

        session.close();
        return (List<Customer>) customers;
    }

    public void create(Customer customer){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(customer);
        transaction.commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(customer);
        transaction.commit();
        session.close();
    }
}
