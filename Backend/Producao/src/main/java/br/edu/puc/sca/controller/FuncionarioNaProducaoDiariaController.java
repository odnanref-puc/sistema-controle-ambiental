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

import br.edu.puc.sca.model.FuncionarioNaProducaoDiaria;
import br.edu.puc.sca.repository.FuncionarioCustomRepository;
import br.edu.puc.sca.repository.FuncionarioNaProducaoDiariaRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FuncionarioNaProducaoDiariaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    FuncionarioNaProducaoDiariaRepository repository;
    @Autowired
    FuncionarioCustomRepository funcionarioRepository;
   
    
    @RequestMapping("/funcionario_na_producao_diaria/{funcionarioId}/{producaoId}")
    Resultado funcionarioNaProducaoDiariaById(@PathVariable("funcionarioId") int funcionarioId, @PathVariable("producaoId") int producaoId){
    	FuncionarioNaProducaoDiaria funcionarioNaProducaoDiaria = repository.findOne(new FuncionarioNaProducaoDiaria.Id(Long.valueOf(funcionarioId), Long.valueOf(producaoId)));
        if(funcionarioNaProducaoDiaria == null)
            return new Resultado(1000, "Funcionário na Produção Diária não encontrado");

        Resultado resultado = new RestTemplate().getForObject("http://api_gateway:80/funcionario/" + funcionarioId, Resultado.class);              
        if(resultado == null)
            return new Resultado(1000, "Funcionário na Produção Diária não encontrado");       

        return resultado;
    }
    
    
    @RequestMapping("/funcionario_na_producao_diaria/{producaoId}")
    Resultado funcionarioNaProducaoDiariaByProducaoId(@PathVariable("producaoId") int producaoId){
    	
    	List<Object> funcionarios = new ArrayList<Object>();                
        Iterator<FuncionarioNaProducaoDiaria> it = funcionarioRepository.find(Long.valueOf(producaoId)).iterator();       
        
        while(it.hasNext()) {
        	FuncionarioNaProducaoDiaria funcionarioNaProducaoDiaria = (FuncionarioNaProducaoDiaria)it.next();
        	Resultado r = new RestTemplate().getForObject("http://api_gateway:80/funcionario/" + funcionarioNaProducaoDiaria.getId().getFuncionario_id(), Resultado.class);
        	if(r.getConteudo() != null)
        		funcionarios.add(r.getConteudo());
        }
        
    	Resultado resultado = new Resultado(0, "Sucesso"); 
    	resultado.setConteudo(funcionarios);

        return resultado;
    }    
     
    
    @RequestMapping("/funcionario_na_producao_diaria")
    Resultado funcionarioNaProducaoDiariaAll(){
    	
    	List<Object> funcionarios = new ArrayList<Object>();                
        Iterator<FuncionarioNaProducaoDiaria> it = repository.findAll().iterator();       
        
        while(it.hasNext()) {
        	FuncionarioNaProducaoDiaria funcionarioNaProducaoDiaria = (FuncionarioNaProducaoDiaria)it.next();
        	Resultado r = new RestTemplate().getForObject("http://api_gateway:80/funcionario/" + funcionarioNaProducaoDiaria.getId().getFuncionario_id(), Resultado.class);
        	if(r.getConteudo() != null)
        		funcionarios.add(r.getConteudo());
        }
        
    	Resultado resultado = new Resultado(0, "Sucesso"); 
    	resultado.setConteudo(funcionarios);
        

       return resultado;
    }    
    
}
