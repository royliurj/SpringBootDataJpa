package com.roy.springbootdatajpa.dao;

import com.roy.springbootdatajpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
