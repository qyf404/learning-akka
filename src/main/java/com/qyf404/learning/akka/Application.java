package com.qyf404.learning.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.qyf404.learning.akka.order.SellerActor;


public class Application {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef seller = system.actorOf(SellerActor.props());

        seller.tell(new SellerActor.CreateOrder("Think in Java"), ActorRef.noSender());
    }
}
