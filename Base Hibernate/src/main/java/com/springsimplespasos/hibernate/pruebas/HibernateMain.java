package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.domain.Card;
import com.springsimplespasos.hibernate.domain.Partner;
import com.springsimplespasos.hibernate.domain.Person;
import com.springsimplespasos.hibernate.domain.Phone;
import com.springsimplespasos.hibernate.domain.Publication;
import com.springsimplespasos.hibernate.domain.SimpleEntity;
import com.springsimplespasos.hibernate.domain.User;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        /*Partner partner = new Partner();
        partner.setName("Matias");
        partner.setDocument("123456789");

        //OneToOne
        Partner getPartner = session.get(Partner.class, 1);
        System.out.println("getPartner = " + getPartner);
        Card card = new Card();
        card.setNumber("01");
        card.setPartner(getPartner);*/
        //partner.setCard(card);

        //ManyToOne
        /*Person person = new Person(null, "Matias");
        Person person1 = new Person(null, "Nicolas");

        Phone phone = new Phone(null, "123456789", person);
        Phone phone1 = new Phone(null, "987654321", person);
        person.setPhones(Arrays.asList(phone, phone1));*/

        //session.beginTransaction();
        /*Person person = session.get(Person.class, 1);
        List<String> numbers = new ArrayList<>();
        person.getPhones().forEach(phone -> numbers.add(phone.getNumber()));
        numbers.forEach(System.out::println);*/

        //ManyToMany
        session.beginTransaction();

        User admin = new User(1, "Admin");
        User user = new User(2, "User");

        Publication publication1 = new Publication(3, "Publication´s text 1");
        Publication publication2 = new Publication(4, "Publication's text 2");
        Publication publication3 = new Publication(5, "Publication's text 3");
        Publication publication4 = new Publication(6, "Publication's text 4");

        /*admin.setPublications(Arrays.asList(publication1, publication2));
        user.setPublications(Arrays.asList(publication3, publication4,publication2));*/

        /*session.saveOrUpdate(admin);
        session.saveOrUpdate(user);
        session.saveOrUpdate(publication1);
        session.saveOrUpdate(publication2);
        session.saveOrUpdate(publication3);
        session.saveOrUpdate(publication4);*/
        User getUser = session.get(User.class, 1);
        System.out.println("List's of publications of user: " + getUser.getName());
        getUser.getPublications().forEach(publication -> System.out.println(publication.getText()));
        System.out.println();

        Publication getPublication = session.get(Publication.class, 3);
        System.out.println("List's of publications of admin: " + admin.getName());
        getPublication.getUsers().forEach(item -> System.out.println("User: " + item.getName()));
        session.getTransaction().commit();
        session.close();
    }

}
