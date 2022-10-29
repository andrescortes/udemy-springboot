package com.springsimplespasos.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name",length = 40)
    private String name;
    @Column(name = "document",length = 40, unique = true)
    private String document;

    @OneToOne(mappedBy = "partner", cascade = CascadeType.ALL)
    private Card card;

    public Partner() {
    }

    public Partner(Integer id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Partner{" + "id=" + id + ", name='" + name + '\'' + ", document='" + document + '\''
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Partner)) {
            return false;
        }
        Partner that = (Partner) o;
        return getId().equals(that.getId()) && getName().equals(that.getName())
            && getDocument().equals(that.getDocument());
    }

}
