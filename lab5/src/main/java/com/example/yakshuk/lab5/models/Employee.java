package com.example.yakshuk.lab5.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int id;
    private String name;
    private double salary;
    private String deg;
    @ManyToOne
    private Department department;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDeg() {
        return deg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public Employee(int id,
                    String name, double salary, String deg)
    {
        super( );
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deg = deg;
    }

    public int getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}