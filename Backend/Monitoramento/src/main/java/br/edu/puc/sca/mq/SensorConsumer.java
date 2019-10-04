package br.edu.puc.sca.mq;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import br.edu.puc.sca.model.DadosSensor;
import br.edu.puc.sca.repository.DadosSensorRepository;
import br.edu.puc.sca.retorno.Resultado;
import br.edu.puc.sca.util.Utilidade;
import javax.naming.InitialContext;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.JMSException;

public class SensorConsumer {
	
    @Autowired
    DadosSensorRepository repository;

    private ConnectionFactory connectionFactory;   
    private Queue queue;
    private Connection connection = null;
    private InitialContext initialContext = null;   
    private TextMessage mensagem;
    private Session session;
    private MessageConsumer msgConsumer;

    public void consumirDados() throws InterruptedException, Exception {  
        
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
            msgConsumer = session.createConsumer(queue);
            connection.start();            
            while (true) {                     
                 mensagem = (TextMessage) msgConsumer.receive();
                if (mensagem != null) {
                    System.out.println("Recebida as seguintes mensagens: " + mensagem.getText());
                    DadosSensor dadosSensor = Utilidade.JsonToObject(mensagem.getText());
                    
                    new RestTemplate().postForObject("http://localhost:8081/dados_sensor", dadosSensor, Resultado.class);
                    
                    System.out.println("Sensor ID: " +dadosSensor.getSensor_id());
                    System.out.println("Sensor Pressao: " +dadosSensor.getPressao());
                    System.out.println("Sensor Temperatura: " +dadosSensor.getTemperatura());                                    
                }                                            
                Thread.sleep(3000);
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
