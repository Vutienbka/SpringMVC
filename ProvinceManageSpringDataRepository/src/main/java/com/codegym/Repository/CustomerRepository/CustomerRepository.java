package com.codegym.Repository.CustomerRepository;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    List<Customer> findAllByProvince(Optional<Province> province);
}
