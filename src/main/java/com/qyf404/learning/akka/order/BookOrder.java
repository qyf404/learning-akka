package com.qyf404.learning.akka.order;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

import javax.persistence.*;

@Entity
public class BookOrder {

    @Id
    public Long id;

    @Version
    public Long version;

    public String bookName;

    public void save(){
        EbeanServer server = Ebean.getDefaultServer();
        server.save(this);
    }
}
