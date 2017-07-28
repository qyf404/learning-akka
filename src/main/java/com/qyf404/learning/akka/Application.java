package com.qyf404.learning.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.qyf404.learning.akka.order.SellerActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static akka.pattern.PatternsCS.ask;
import static java.lang.Thread.sleep;


public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ActorSystem system = ActorSystem.create();
        ActorRef seller = system.actorOf(SellerActor.props());

        CompletableFuture<SellerActor.Response> resp = ask(seller, new SellerActor.CreateOrder("Think in Java"), 10000)
                .thenApply(response -> {
                    if (response instanceof SellerActor.Response) {
                        return (SellerActor.Response) response;
                    }
                    return new SellerActor.Response(response.toString());
                })
                .exceptionally(e -> {
                    LOGGER.error("下单异常.", e);
                    return null;
                })
                .toCompletableFuture();

        LOGGER.info("seller answer is '{}'", resp.get().message);

        sleep(5000);
        system.terminate();
    }
}
