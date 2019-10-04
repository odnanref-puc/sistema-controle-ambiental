package br.edu.puc.sca.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.model.ProducaoDiaria;
import br.edu.puc.sca.repository.ProducaoCustomRepository;
import br.edu.puc.sca.repository.ProducaoDiariaRepository;
//import br.edu.puc.sca.repository.ProducaoRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProducaoDiariaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    ProducaoDiariaRepository repository;
    @Autowired
    ProducaoCustomRepository producaoRepository;
    
    @RequestMapping("/producao_diaria/{id}")
    Resultado producaoById(@PathVariable("id") int id){
    	ProducaoDiaria producaoDiaria = repository.findOne(Long.valueOf(id));
        if(producaoDiaria == null)
            return new Resultado(1000, "Produção Diária não encontrada");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(producaoDiaria);

        return resultado;
    }

    @RequestMapping("/producao_diaria")
    Resultado producaoAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }

  
    @RequestMapping("/producao_mina/{id}")
    Resultado producaoByMina(@PathVariable("id") int id){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(producaoRepository.find(Long.valueOf(id)));

        return resultado;
    }
    
    
    @RequestMapping("/producao_mina/{id}/{data}")
    Resultado producaoByMinaAndData(@PathVariable("id") int id, @PathVariable("data") long data){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(producaoRepository.find(Long.valueOf(id), new Date(data)));

        return resultado;
    }
    
    @RequestMapping("/producao_mina/{id}/{data_inicial}/{data_final}")
    Resultado producaoByMinaAndPeriodo(@PathVariable("id") int id, @PathVariable("data_inicial") long data_inicial, @PathVariable("data_final") long data_final){      	
    	Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(producaoRepository.find(Long.valueOf(id), new Date(data_inicial), new Date(data_final)));

        return resultado;
    }
  
}
