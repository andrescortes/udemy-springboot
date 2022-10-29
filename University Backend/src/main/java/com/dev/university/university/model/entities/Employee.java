package com.dev.university.university.model.entities;

import com.dev.university.university.model.entities.enums.EmployeeType;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person {

    private BigDecimal salary;
    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "pavilion_id"
    )
    private Pavilion pavilion;

    public Employee() {
    }

    public Employee(Integer id, String name, String lastName, String dni, Address address,
        BigDecimal salary, EmployeeType employeeType) {
        super(id, name, lastName, dni, address);
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\tEmployee{" +
            "salary=" + salary +
            ", employeeType=" + employeeType +
            '}';
    }
}
