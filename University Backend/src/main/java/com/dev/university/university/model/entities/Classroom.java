package com.dev.university.university.model.entities;

import com.dev.university.university.model.entities.enums.Pizzarra;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "classrooms")
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_classroom", nullable = false)
    private Integer classroomNumber;
    @Column(name = "dimensions_mtsxmts")
    private String dimensions;
    @Column(name = "amount_seats")
    private Integer seatsNumber;
    @Column(name = "type_board")
    @Enumerated(EnumType.STRING)
    private Pizzarra pizzarra;
    @Column(name = "date_discharge")
    private LocalDate dischargeDate;
    @Column(name = "date_update")
    private LocalDate dateUpdate;
    @ManyToOne(
        optional = true,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinColumn(
        name = "classroom_id",
        foreignKey = @ForeignKey(name = "FK_PAVILION_ID")
    )
    private Pavilion pavilion;

    public Classroom() {
    }

    public Classroom(Integer id, Integer classroomNumber, String dimensions, Integer seatsNumber,
        Pizzarra pizzarra) {
        this.id = id;
        this.classroomNumber = classroomNumber;
        this.dimensions = dimensions;
        this.seatsNumber = seatsNumber;
        this.pizzarra = pizzarra;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Pizzarra getPizzarra() {
        return pizzarra;
    }

    public void setPizzarra(Pizzarra pizzarra) {
        this.pizzarra = pizzarra;
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

    public void setDateUpdate(LocalDate dateLastUpdate) {
        this.dateUpdate = dateLastUpdate;
    }

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
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
        return "Classroom{" +
            "id=" + id +
            ", classroomNumber=" + classroomNumber +
            ", dimensions='" + dimensions + '\'' +
            ", seatsNumber=" + seatsNumber +
            ", pizzarra=" + pizzarra +
            ", dischargeDate=" + dischargeDate +
            ", dateLastUpdate=" + dateUpdate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Classroom)) {
            return false;
        }
        Classroom classroom = (Classroom) o;
        return getId().equals(classroom.getId()) && getClassroomNumber().equals(
            classroom.getClassroomNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClassroomNumber());
    }
}
