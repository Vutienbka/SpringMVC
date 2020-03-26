package com.codegym.CustomerRepository;

import com.codegym.CustomerService.ICustomerService;
import com.codegym.Model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.internal.DefaultPersistEventListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class CustomerRepositoryHibernate implements ICustomerService {

    SessionFactory sessionFactory;
    EntityManager entityManager;


    public CustomerRepositoryHibernate(){
        this.sessionFactory= new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        this.entityManager = this.sessionFactory.createEntityManager();
    }

    @Override
    public ArrayList<Customer> getAllCustomer() {
        //entityManager.getTransaction().begin();
        String query = "SELECT s FROM Customer s";
        ArrayList<Customer> customerList = (ArrayList<Customer>) (this.entityManager.createQuery(query, Customer.class).getResultList());
        //entityManager.close();
        return customerList;
    }

    @Override
    public Customer findById(int customerId) {

        TypedQuery<Customer> query = entityManager.createQuery("SELECT s FROM Customer s WHERE s.Id=:customerId", Customer.class);
        query.setParameter("customerId", customerId);

        return query.getSingleResult();
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        if(customer.getId()>0){
            entityManager.merge(customer);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        Customer customer= findById(customerId);
        entityManager.getTransaction().begin();
        if (customer!=null) {
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            //entityManager.close();
            return true;
        }else return false;
    }

    @Override
    public boolean addCustomer(Customer newCustomer) {

        entityManager.getTransaction().begin();
        if(newCustomer.getId()>0) {
            try {
                this.entityManager.persist(newCustomer);
            }catch (NoResultException e){
                e.printStackTrace();
            }
            entityManager.getTransaction().commit();
        }
          Customer customer = findById(newCustomer.getId());
        if(customer!=null){
            //entityManager.close();
            return true;
        }else{
            //entityManager.close();
            return false;
        }
    }

    @Override
    public ArrayList<Customer> customerSearch(String querySearch) {
        if(querySearch!=null) {
            return (ArrayList<Customer>) entityManager.createQuery("SELECT s FROM Customer s WHERE s.customerName LIKE '%"+ querySearch +"%'", Customer.class).getResultList();
        }else return getAllCustomer();
    }
}
