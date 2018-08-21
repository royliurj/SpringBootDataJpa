package com.roy.springbootdatajpa.dao;

import com.roy.springbootdatajpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
