package com.qyf404.learning.akka.order;

import akka.actor.AbstractActor;
import akka.actor.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerActor extends AbstractActor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SellerActor.class);

    private SellerActor() {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(CreateOrder.class, co -> {
                    LOGGER.info("Seller is creating order.");
                    BookOrder bookOrder = new BookOrder();
                    bookOrder.bookName = co.bookName;
                    bookOrder.save();
                    LOGGER.info("Seller is created order.");
                })
                .build();
    }

    public static Props props() {
        return Props.create(SellerActor.class, SellerActor::new);
    }

    public static class CreateOrder {
        public CreateOrder(String bookName) {
            this.bookName = bookName;
        }

        public final String bookName;
    }
}
