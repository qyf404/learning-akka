package com.qyf404.learning.akka.order;


import com.qyf404.learning.akka.common.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "book_order")
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Version
    public Long version;

    @Column(name = "book_name")
    public String bookName;

    public void save(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
    }
}
