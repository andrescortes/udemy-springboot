package com.dev.university.university.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persons")
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 10,unique = true)
    private String dni;
    @Column(name = "date_discharge")
    private LocalDate dischargeDate;
    @Column(name = "date_update")
    private LocalDate dateUpdate;
    @Embedded//add attributes from Address class to this class Pavilion
    @AttributeOverrides({
        @AttributeOverride(name = "zipcode", column = @Column(name = "postal_code")),
        @AttributeOverride(name = "dpto", column = @Column(name = "department")),
    })
    private Address address;

    public Person() {
    }

    public Person(Integer id, String name, String lastName, String dni, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public LocalDate getDateLastUpdate() {
        return dateUpdate;
    }

    public void setDateLastUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @PrePersist// before save to database update dischargeDate with current date
    private void beforePersist() {
        this.dischargeDate = LocalDate.now();
    }

    @PreUpdate // before update to database updateDate update with current date
    private void beforeUpdate() {
        this.dateUpdate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", dni='" + dni + '\'' +
            ", dischargeDate=" + dischargeDate +
            ", dateUpdate=" + dateUpdate +
            ", address=" + address +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return getId().equals(person.getId()) && getDni().equals(person.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDni());
    }
}
