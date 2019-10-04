package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.puc.sca.model.DadosSensor;
import br.edu.puc.sca.repository.DadosSensorRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DadosSensorController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    DadosSensorRepository repository;

    @RequestMapping("/dados_sensor/{id}")
    Resultado dadosSensorById(@PathVariable("id") int id){
    	DadosSensor dadosSensor = repository.findOne(Long.valueOf(id));
        if(dadosSensor == null)
            return new Resultado(1000, "Dados do sensor não encontrados");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(dadosSensor);

        return resultado;
    }

    @RequestMapping("/dados_sensor")
    Resultado dadosSensorAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
    
    @RequestMapping(value = "/dados_sensor", method = RequestMethod.POST, headers = {"content-type=application/json"})
    Resultado ativoPost(@RequestBody DadosSensor dadosSensor){
    	repository.save(dadosSensor);   	
        Resultado resultado = new Resultado(0, "Dados do sensor cadastrados com sucesso");
        return resultado;

    } 
    
}
