package com.iplacex;

import com.iplacex.route.SimpleRedafiRouter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class MainApp {

    public static void main(String[] args) throws Exception {
        System.out.println("********************************************************");
        System.out.println("Testing Application Document to Message REDAFI!!........");
        System.out.println("........................................................");
        System.out.println("Examen Integracion de Sistemas CamelActiveMq............");
        System.out.println("........................................................");
        System.out.println("Starting Application Document to Message Redafi....!!...");
        System.out.println("........................................................");
        System.out.println("********************************************************");
        System.out.println("IPlacex Tecnológico Nacional - Septiembre - 2023........");
        System.out.println("********************************************************");
        System.out.println("........................................................");
        System.out.println("*******Robinson Concha Alumno ING Informática***********");

        SimpleRedafiRouter myRouteBuilder = new SimpleRedafiRouter();
        CamelContext camelContext = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try {
            camelContext.addRoutes(myRouteBuilder);
            camelContext.start();
            Thread.sleep(1000 * 60 * 5);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

