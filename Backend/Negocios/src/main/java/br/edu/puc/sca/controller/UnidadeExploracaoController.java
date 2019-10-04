package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.retorno.Resultado;
import br.edu.puc.sca.model.UnidadeExploracao;
import br.edu.puc.sca.repository.UnidadeExploracaoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UnidadeExploracaoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    UnidadeExploracaoRepository repository;

    @RequestMapping("/mina/{id}")
    Resultado unidadeExploracaoById(@PathVariable("id") int id){

        UnidadeExploracao unidadeExploracao = repository.findOne(Long.valueOf(id));
        if(unidadeExploracao == null)
            return new Resultado(1000, "Risco não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(unidadeExploracao);

        return resultado;
    }

    @RequestMapping("/mina")
    Resultado unidadeExploracaoAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

        return resultado;
    }
}
