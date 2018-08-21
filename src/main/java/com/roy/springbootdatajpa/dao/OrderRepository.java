package com.roy.springbootdatajpa.dao;

import com.roy.springbootdatajpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
