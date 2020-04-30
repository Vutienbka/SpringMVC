package com.codegym.CustomerRepository;

import com.codegym.Model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomer() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer findById(Long customerId) {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.Id=:customerId",Customer.class);
        query.setParameter("customerId",customerId);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId()!=null)
        entityManager.merge(customer);
    }

    @Override
    public void remove(Customer customer) {
        Customer removingCustomer = findById(customer.getId());
        entityManager.remove(removingCustomer);
    }

    @Override
    public List<Customer> searchCustomerByName(String queryString) {
        if(queryString!=null){
            TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerName " +
                    "LIKE '%" + queryString + "%' ",Customer.class);
            return query.getResultList();
        }else return getAllCustomer();
    }
}
