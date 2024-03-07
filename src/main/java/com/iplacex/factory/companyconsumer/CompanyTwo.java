package com.iplacex.factory.companyconsumer;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class CompanyTwo {
    public CompanyTwo() {
    }
    public void receiveMessage() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("EMPRESA2.QUEUE");
            MessageConsumer consumer = session.createConsumer(destination);
            boolean end = false;
            while (!end) {
                Message message = consumer.receive();
                if (message instanceof TextMessage) {
                    TextMessage text = (TextMessage) message;
                    System.out.println("********************************************************");
                    System.out.println("Message Received Successfully : " + text.getText());
                    System.out.println("********************************************************");
                    System.out.println("........................................................");
                }else {
                    end = true;
                }
            }
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CompanyTwo consumer = new CompanyTwo();
        consumer.receiveMessage();
    }
}

