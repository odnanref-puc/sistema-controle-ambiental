package br.edu.puc.sca.mq;

import javax.naming.NamingException;
import br.edu.puc.sca.bean.Email;
import br.edu.puc.sca.util.Utilidade;
import javax.naming.InitialContext;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.DeliveryMode;
import javax.jms.TextMessage;
import javax.jms.JMSException;

public class EmailPublisher {

    private ConnectionFactory connectionFactory;   
    private Queue queue;
    private Connection connection = null;
    private InitialContext initialContext = null;   
    private TextMessage mensagem;
    private Session session;
    private MessageProducer msgProducer;

    public void enviar(Email email) throws InterruptedException, Exception {       
        
        try {
            initialContext = new InitialContext();
            connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory"); 
            queue = (Queue) initialContext.lookup("queue/email");
        } catch (NamingException e) {
            System.err.println("NamingException: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
           
        try {
            connection = connectionFactory.createConnection("admin", "admin");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            msgProducer = session.createProducer(queue);
            connection.start();            
     
	        mensagem = session.createTextMessage(Utilidade.objectToJson(email));
	        msgProducer.send(mensagem, DeliveryMode.NON_PERSISTENT, 4, 0);               
        
        } catch (JMSException e) {
            System.err.println("JMSException: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
