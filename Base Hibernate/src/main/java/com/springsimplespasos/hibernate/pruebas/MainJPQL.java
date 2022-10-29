package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.domain.Person;
import com.springsimplespasos.hibernate.domain.Phone;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class MainJPQL {

    public static void main(String[] args) {
        //sql native SELECT * FROM entity WHERE description = 'hola'
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Query query = session.createQuery("select p from Person p where p.id = ?1");
        query.setParameter(1, Integer.parseInt("1"));

        Person person = (Person) query.getSingleResult();
        //SELECT * FROM persons p JOIN phones ph ON p.id = ph.id WHERE p.id = 1

        Query query2 = session.createQuery("select p.phones from Person p where p.id = :id");
        query2.setParameter("id", Integer.parseInt("1"));
        List<Phone> phones = (List<Phone>) query2.getResultList();
        System.out.println("Phones: ");
        phones.forEach(phone -> System.out.println(phone.getNumber()));

        System.out.println(person.getName());

        session.close();
    }
}
