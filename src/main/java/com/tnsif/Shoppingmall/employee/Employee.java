package com.tnsif.Shoppingmall.employee;

import jakarta.persistence.*;

import com.tnsif.Shoppingmall.shop.Shops;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shops shop;

    public Employee() {}

    public Employee(Long id, String name, String designation, double salary, Shops shop) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.shop = shop;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Shops getShop() { return shop; }
    public void setShop(Shops shop) { this.shop = shop; }
}