package com.example.ChatWithJMS.adapters.javaMessageService;

import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.JMS;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class JavaMessageServiceWithActiveMQ implements JMS {

    private  static final String ACTIVE_MQ_URL = "tcp://localhost:61613";

    @Override
    public void activeMq(Information information) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        try(Connection connection = connectionFactory.createConnection()){
            Session ses = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = ses.createTopic(information.getDuctName());

            MessageProducer messageProducer = ses.createProducer(topic);
            TextMessage message = ses.createTextMessage(information.msgToJson());
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
