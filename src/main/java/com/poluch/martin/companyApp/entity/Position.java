package com.poluch.martin.companyApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Position extends BaseEntity {

    @Column(name = "position")
    private String name;

    @Column(name = "employees")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    private Set<Employee> employees;

    public Position() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return name;
    }
}
