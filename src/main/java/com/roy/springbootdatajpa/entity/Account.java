package com.roy.springbootdatajpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "jpa_account")
public class Account {

//    @Id
//    @GeneratedValue(generator = "pkGenerator")
//    @GenericGenerator(name = "pkGenerator", strategy = "native")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "account_name")
    private String accountName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
