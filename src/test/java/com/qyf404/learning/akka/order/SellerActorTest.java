package com.qyf404.learning.akka.order;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import io.ebean.Ebean;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


public class SellerActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() throws SQLException {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() throws SQLException {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void should_seller_can_create_order() {
        final ActorRef seller = system.actorOf(SellerActor.props());
        seller.tell(new SellerActor.CreateOrder("Think in Java"), ActorRef.noSender());
        BookOrder bookOrder = Ebean.find(BookOrder.class).findUnique();
        assertThat(bookOrder.bookName).isEqualTo("Think in Java");
    }
}
