package com.qyf404.learning.akka.order;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import com.qyf404.learning.akka.Application;
import com.qyf404.learning.akka.common.HibernateUtil;
import org.h2.tools.Server;
import org.testng.annotations.*;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SellerActorTest {
    private ActorSystem system;
    static Server server;

    @BeforeClass
    public static void setup() throws SQLException {
        server = Server.createTcpServer(new String[]{"-tcpPort", "9080"}).start();
    }

    @AfterClass
    public static void teardown() throws SQLException {
        server.stop();
    }

    @BeforeMethod
    public void before() {
        system = ActorSystem.create();
    }

    @AfterMethod
    public void after() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void should_seller_can_create_order() {
        final ActorRef seller = system.actorOf(SellerActor.props());
        seller.tell(new SellerActor.CreateOrder("Think in Java"), ActorRef.noSender());

        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
        List bookOrderList = em.createQuery("select o from BookOrder o").getResultList();
        em.getTransaction().commit();
        em.close();
        BookOrder bookOrder = (BookOrder) bookOrderList.get(0);

        assertThat(bookOrder.bookName).isEqualTo("Think in Java");
    }
}
