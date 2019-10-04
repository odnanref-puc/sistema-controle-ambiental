package br.edu.puc.sca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.puc.sca.mq.Mailer;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Mailer mailer = new Mailer();  
        try {
        	mailer.enviarMensagem();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}