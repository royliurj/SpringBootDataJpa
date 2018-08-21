package com.roy.springbootdatajpa.controller;

import com.roy.springbootdatajpa.dao.AccountRepository;
import com.roy.springbootdatajpa.dao.CustomerRepository;
import com.roy.springbootdatajpa.dao.DoctorRepository;
import com.roy.springbootdatajpa.dao.OrderRepository;
import com.roy.springbootdatajpa.entity.Account;
import com.roy.springbootdatajpa.entity.Customer;
import com.roy.springbootdatajpa.entity.Doctor;
import com.roy.springbootdatajpa.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @RequestMapping("/initAccount")
    public String initAccount(){

        Account account = new Account();
        account.setAccountName("account name 1");

        Doctor doctor = new Doctor();
        doctor.setHospitalId(1);

        account.setDoctor(doctor);

        doctor.setAccount(account);

        accountRepository.save(account);

        return "Success";
    }

    @RequestMapping("/initAccount2")
    public String initAccount2(){

        Doctor doctor = new Doctor();
        doctor.setHospitalId(1);

        Account account = new Account();
        account.setAccountName("asdf");

        doctor.setAccount(account);

        doctorRepository.save(doctor);

        return "Success";
    }

    @RequestMapping("/hello")
    public String hello(){
        Customer customer = new Customer();
        customer.setCustomerName("C1");
        customer.setInfo("asdfasd");

        customerRepository.save(customer);

        Order order = new Order();
        order.setOrderName("order 1");
        order.setSn("sdfasdf");
        order.setCustomer(customer);
        orderRepository.save(order);




        Account account = new Account();

        account.setAccountName("account 1");
//        Doctor doctor = new Doctor();
//        doctor.setHospitalName("Hospital name");
//
//        account.setDoctor(doctor);

        accountRepository.save(account);
        //doctorRepository.save(doctor);
        return "Hello";
    }

    @RequestMapping("/add")
    public String add(){

        Customer customer = new Customer();
        customer.setCustomerName("C1");
        customer.setInfo("asdfasd");


        Order order = new Order();
        order.setOrderName("order 1");
        order.setSn("sdfasdf");
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        customer.setOrders(orders);

//        orderRepository.save(order);
        customerRepository.save(customer);
        return "Hello";
    }

    @RequestMapping("/getCustomer/{id}")
    public String getCustomer(@PathVariable("id") Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println(customer.get());


        return "getCustomer";
    }

    @RequestMapping("/getOrderById/{id}")
    public String getOrder(@PathVariable("id") Integer id){
        Optional<Order> order = orderRepository.findById(id);
        System.out.println(order.get());

        System.out.println(order.get().getCustomer());
        return "getOrderById";
    }
}
