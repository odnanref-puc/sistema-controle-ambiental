package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.model.Funcionario;
import br.edu.puc.sca.repository.FuncionarioRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FuncionarioController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    FuncionarioRepository repository;

    @RequestMapping("/funcionario/{id}")
    Resultado funcionarioById(@PathVariable("id") int id){
    	Funcionario funcionario = repository.findOne(Long.valueOf(id));
        if(funcionario == null)
            return new Resultado(1000, "Funcionário não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(funcionario);

        return resultado;
    }

    @RequestMapping("/funcionario")
    Resultado funcionarioAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
}
