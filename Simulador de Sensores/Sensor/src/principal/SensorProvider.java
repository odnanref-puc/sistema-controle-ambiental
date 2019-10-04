package principal;

import java.text.DecimalFormat;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.DeliveryMode;
import javax.jms.TextMessage;
import javax.jms.JMSException;
import sensor.Sensor;
import util.Utilidade;

public class SensorProvider {

    private ConnectionFactory connectionFactory;   
    private Queue queue;
    private Connection connection = null;
    private InitialContext initialContext = null;   
    private TextMessage mensagem;
    private Session session;
    private MessageProducer msgProducer;

    public void enviarDados() throws InterruptedException, Exception {
        
        DecimalFormat df = new DecimalFormat("#.##");  
        
        try {
            initialContext = new InitialContext();
            connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory"); 
            queue = (Queue) initialContext.lookup("queue/sensor");
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
            while (true) {
                mensagem = session.createTextMessage(Utilidade.objectToJson(new Sensor("1", df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."), df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."))));
                msgProducer.send(mensagem, DeliveryMode.NON_PERSISTENT, 4, 0);
                mensagem = session.createTextMessage(Utilidade.objectToJson(new Sensor("2", df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."), df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."))));
                msgProducer.send(mensagem, DeliveryMode.NON_PERSISTENT, 4, 0);
                mensagem = session.createTextMessage(Utilidade.objectToJson(new Sensor("4", df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."), df.format(Utilidade.sorteiaNumero()).replaceFirst(",","."))));
                msgProducer.send(mensagem, DeliveryMode.NON_PERSISTENT, 4, 0);                
                Thread.sleep(8000);
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }
        
    public static void main(String args[]) throws InterruptedException, Exception {   
        SensorProvider provider = new SensorProvider();
        provider.enviarDados();
    }
}
