package br.edu.puc.sca.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.puc.sca.bean.Email;
import br.edu.puc.sca.model.Pessoa;
import br.edu.puc.sca.mq.EmailPublisher;
import br.edu.puc.sca.repository.PessoaCustomRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmailController {
    @Autowired
    PessoaCustomRepository customRepository;
    
    @RequestMapping(value = "/email", method = RequestMethod.POST, headers = {"content-type=application/json"})
    Resultado enviarEmail(@RequestBody Email email){
    	
    	email.setRemetente("sca.puc.minas@gmail.com");
    	email.setSenha("tccsca2019");
    	
    	Iterator<Pessoa> it = customRepository.find(Long.valueOf(email.getMina_id())).iterator();
    	while(it.hasNext()) {
    		email.setDestinatario(it.next().getEmail());
    		try {
    			new EmailPublisher().enviar(email); 
    			System.out.println("===> "+email.toString());
    		}catch(Exception e) {
    			e.printStackTrace();
    		}   		  		
    	}

        Resultado resultado = new Resultado(0, "Email enviado com sucesso");
        return resultado;
    } 
    

}
