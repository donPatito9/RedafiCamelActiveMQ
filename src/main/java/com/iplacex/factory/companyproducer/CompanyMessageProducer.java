package com.iplacex.factory.companyproducer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class CompanyMessageProducer {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;
    public CompanyMessageProducer() {
    }
    public void sendMessage() {
        try {
            factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("pedidosAhora");
            producer = session.createProducer(destination);

            TextMessage message = session.createTextMessage();
            message.setText("Hello ...This is a  message..sending to Received  PedidosAhora Application!!");
            producer.send(message);
            System.out.println("*********************************************************************************************");
            System.out.println(".............................................................................................");
            System.out.println("Sending Message: " + message.getText());
            System.out.println(".............................................................................................");
            System.out.println("*********************************************************************************************");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CompanyMessageProducer producer = new CompanyMessageProducer();
        producer.sendMessage();
    }
}
