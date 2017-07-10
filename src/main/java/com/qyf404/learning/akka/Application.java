package com.qyf404.learning.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.qyf404.learning.akka.order.SellerActor;
import org.avaje.agentloader.AgentLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    static{
//        if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent","debug=1;packages=org.example.model")) {
        if (!AgentLoader.loadAgentFromClasspath("ebean-agent","debug=1;packages=org.example.model")) {
            LOGGER.info("ebean-agent not found in classpath - not dynamically loaded");
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef seller = system.actorOf(SellerActor.props());

        seller.tell(new SellerActor.CreateOrder("Think in Java"), ActorRef.noSender());
    }
}
