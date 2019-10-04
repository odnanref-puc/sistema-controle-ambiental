package br.edu.puc.sca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.puc.sca.mq.SensorConsumer;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        
        try {            
            SensorConsumer consumer = new SensorConsumer();
            consumer.consumirDados();       
        }catch(Exception e) {
        	
        }
    }
}