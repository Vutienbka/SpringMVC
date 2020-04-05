package com.codegym.Repository.CustomerRepository;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByCustomerNameContaining(Optional<String> name, Pageable pageable);
}
