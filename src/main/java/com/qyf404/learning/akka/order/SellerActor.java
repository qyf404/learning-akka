package com.qyf404.learning.akka.order;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class SellerActor extends AbstractActor {
    private SellerActor() {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(CreateOrder.class, co -> {
                    BookOrder bookOrder = new BookOrder();
                    bookOrder.bookName = co.bookName;
                    bookOrder.save();
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
