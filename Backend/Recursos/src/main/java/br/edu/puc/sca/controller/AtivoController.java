package br.edu.puc.sca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.edu.puc.sca.util.OrderById;

import br.edu.puc.sca.model.Ativo;
import br.edu.puc.sca.repository.AtivoRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AtivoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    AtivoRepository repository;

    
    @RequestMapping("/ativo/{id}")
    Resultado ativoById(@PathVariable("id") int id){
    	Ativo ativo = repository.findOne(Long.valueOf(id));
        if(ativo == null)
            return new Resultado(1000, "Ativo não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(ativo);

        return resultado;
    }

    
    @RequestMapping("/ativo")
    Resultado ativoAll(){
        List<Ativo> ativos = repository.findAll();
        ativos.sort(new OrderById());
        
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(ativos);

        return resultado;
    }
    
    
    @RequestMapping(value = "/ativo/{id}", method = RequestMethod.PUT, headers = {"content-type=application/json"})
    Resultado ativoPut(@PathVariable("id") int id, @RequestBody Ativo ativo){ 	
    	repository.save(ativo);   	
        Resultado resultado = new Resultado(0, "Ativo atualizado com sucesso");
        return resultado;
    }
    
    
    @RequestMapping(value = "/ativo", method = RequestMethod.POST, headers = {"content-type=application/json"})
    Resultado ativoPost(@RequestBody Ativo ativo){
    	repository.save(ativo);   	
        Resultado resultado = new Resultado(0, "Ativo cadastrado com sucesso");
        return resultado;

    } 
    
 
    @RequestMapping(value = "/ativo/{id}", method = RequestMethod.DELETE, headers = {"content-type=application/json"})
    Resultado ativoDelete(@PathVariable("id") int id){   	
    	repository.delete(Long.valueOf(id));   	
        Resultado resultado = new Resultado(0, "Ativo excluído com sucesso");
        return resultado;
    }
    
    
}
