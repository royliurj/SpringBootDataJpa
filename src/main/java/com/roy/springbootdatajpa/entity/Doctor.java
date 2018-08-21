package com.roy.springbootdatajpa.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "JPA_Doctor")
public class Doctor {

    @Id
    @GeneratedValue(generator = "pkGenerator")
    @GenericGenerator(
            name = "pkGenerator",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "account"))
    private  Integer accountId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn// 这个注解不能少。如果不加这个注解，添加扩展信息时，就会自动在doctor表中增加了一个外键列account_id.
    private Account account;

    @Column(name = "hospital_id")
    private Integer hospitalId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }
}
