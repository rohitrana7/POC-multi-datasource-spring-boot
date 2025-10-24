package com.mds.poc.psqlentity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderFrom;

    private LocalDate orderDate;

    public Order() {
    }

    public Order(String orderFrom, LocalDate orderDate) {
        this.orderFrom = orderFrom;
        this.orderDate = orderDate;
    }

    public String getOrderFron() {
        return orderFrom;
    }

    public void setOrderFron(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
