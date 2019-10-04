package br.edu.puc.sca.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.puc.sca.model.AtivoNaProducaoDiaria;
import br.edu.puc.sca.repository.AtivoCustomRepository;
import br.edu.puc.sca.repository.AtivoNaProducaoDiariaRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AtivoNaProducaoDiariaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    AtivoNaProducaoDiariaRepository repository;
    @Autowired
    AtivoCustomRepository ativoRepository;
        
    @RequestMapping("/ativo_na_producao_diaria/{ativoId}/{producaoId}")
    Resultado ativoNaProducaoDiariaById(@PathVariable("ativoId") int ativoId, @PathVariable("producaoId") int producaoId){
    	AtivoNaProducaoDiaria ativoNaProducaoDiaria = repository.findOne(new AtivoNaProducaoDiaria.Id(Long.valueOf(ativoId), Long.valueOf(producaoId)));
        if(ativoNaProducaoDiaria == null)
            return new Resultado(1000, "Ativo na Produção Diária não encontrado");      
        
        Resultado resultado = new RestTemplate().getForObject("http://api_gateway:80/ativo/" + ativoId, Resultado.class);              
        if(resultado == null)
            return new Resultado(1000, "Ativo na Produção Diária não encontrado");                      

        return resultado;
    }

    @RequestMapping("/ativo_na_producao_diaria/{producaoId}")
    Resultado ativoNaProducaoDiariaByProducaoId(@PathVariable("producaoId") int producaoId){
    	
    	List<Object> ativos = new ArrayList<Object>();                
        Iterator<AtivoNaProducaoDiaria> it = ativoRepository.find(Long.valueOf(producaoId)).iterator();       
        
        while(it.hasNext()) {
        	AtivoNaProducaoDiaria ativoNaProducaoDiaria = (AtivoNaProducaoDiaria)it.next();
        	Resultado r = new RestTemplate().getForObject("http://api_gateway:80/ativo/" + ativoNaProducaoDiaria.getId().getAtivo_id(), Resultado.class);
        	if(r.getConteudo() != null)
        		ativos.add(r.getConteudo());
        }
        
    	Resultado resultado = new Resultado(0, "Sucesso"); 
    	resultado.setConteudo(ativos);

        return resultado;
    }
    
    
    @RequestMapping("/ativo_na_producao_diaria")
    Resultado ativoNaProducaoDiariaAll(){
    	
    	List<Object> ativos = new ArrayList<Object>();                
        Iterator<AtivoNaProducaoDiaria> it = repository.findAll().iterator();       
        
        while(it.hasNext()) {
        	AtivoNaProducaoDiaria ativoNaProducaoDiaria = (AtivoNaProducaoDiaria)it.next();
        	Resultado r = new RestTemplate().getForObject("http://api_gateway:80/ativo/" + ativoNaProducaoDiaria.getId().getAtivo_id(), Resultado.class);
        	if(r.getConteudo() != null)
        		ativos.add(r.getConteudo());
        }
        
    	Resultado resultado = new Resultado(0, "Sucesso"); 
    	resultado.setConteudo(ativos);
        

       return resultado;
    }
}
