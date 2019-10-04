package br.edu.puc.sca.mq;

import br.edu.puc.sca.bean.Email;
import br.edu.puc.sca.mail.EmailSender;
import br.edu.puc.sca.util.Utilidade;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.JMSException;

public class Mailer {

    private ConnectionFactory connectionFactory;   
    private Queue queue;
    private Connection connection = null;
    private InitialContext initialContext = null;   
    private TextMessage mensagem;
    private Session session;
    private MessageConsumer msgConsumer;

    public void enviarMensagem() throws InterruptedException, Exception {
            
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
            msgConsumer = session.createConsumer(queue);
            connection.start();            
            
            while(true){
            mensagem = (TextMessage) msgConsumer.receive();
                if (mensagem != null) {
                   System.out.println("Recebida as seguintes mensagens: " + mensagem.getText());
                   Email email = Utilidade.JsonToObject(mensagem.getText());
                   new EmailSender().enviarEmail(email);
                   System.out.println("Remetente: " +email.getRemetente());  
                   System.out.println("Senha: " +email.getSenha());
                   System.out.println("Destinatario: " +email.getDestinatario());
                   System.out.println("Assunto: " +email.getAssunto());
                   System.out.println("Mensagem: " +email.getMensagem());
                   Thread.sleep(8000);
                }    
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
