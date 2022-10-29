package com.dev.university.university.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "pavilions")
public class Pavilion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sqaure_meters")
    private Double mts2;
    @Column(name= "pavilion_name", nullable = false,unique = true)
    private String name;
    @Embedded//add attributes from Address class to this class Pavilion
    @AttributeOverrides({
        @AttributeOverride(name = "zipcode", column = @Column(name = "postal_code")),
        @AttributeOverride(name = "dpto", column = @Column(name = "department")),
    })
    private Address address;
    @Column(name = "date_discharge")
    private LocalDate dischargeDate;
    @Column(name = "date_update")
    private LocalDate dateUpdate;

    @OneToMany(mappedBy = "pavilion",
        fetch = FetchType.LAZY
    )
    private Set<Classroom> classrooms;

    @OneToOne(
        mappedBy = "pavilion",
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        optional = true

    )
    private Employee employee;

    public Pavilion() {
    }

    public Pavilion(Integer id, Double mts2, String name, Address address) {
        this.id = id;
        this.mts2 = mts2;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(
        Set<Classroom> classrooms) {
        this.classrooms = classrooms;
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
        return "Pavilion{" +
            "id=" + id +
            ", mts2=" + mts2 +
            ", name='" + name + '\'' +
            ", address=" + address +
            ", dischargeDate=" + dischargeDate +
            ", dateLastUpdate=" + dateUpdate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pavilion pavilion = (Pavilion) o;
        return id.equals(pavilion.id) && name.equals(pavilion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
