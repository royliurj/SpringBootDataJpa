package com.roy.springbootdatajpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "JPA_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "order_name")
    private String orderName;
    private String sn;

    /**
     * @JoinColumn :
     *      name - 列名
     *      foreignKey - 外建信息
      */
    @JoinColumn(name="customer_id",foreignKey = @ForeignKey(name = "FK_Order_Customer",value = ConstraintMode.CONSTRAINT))
    @ManyToOne(fetch=FetchType.LAZY)//使用懒加载
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", orderName='" + orderName + '\'' +
//                ", sn='" + sn + '\'' +
//                ", customer=" + customer +
//                '}';
//    }
}
