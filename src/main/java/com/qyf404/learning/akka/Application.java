package com.qyf404.learning.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.qyf404.learning.akka.order.SellerActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef seller = system.actorOf(SellerActor.props());

        seller.tell(new SellerActor.CreateOrder("Think in Java"), ActorRef.noSender());
    }
}
