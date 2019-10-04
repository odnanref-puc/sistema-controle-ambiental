package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.retorno.Resultado;
import br.edu.puc.sca.model.Risco;
import br.edu.puc.sca.repository.RiscoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RiscoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    RiscoRepository repository;

    @RequestMapping("/risco/{id}")
    Resultado riscoById(@PathVariable("id") int id){
        Risco risco = repository.findOne(Long.valueOf(id));
        if(risco == null)
            return new Resultado(1000, "Risco não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(risco);

        return resultado;
    }

    @RequestMapping("/risco")
    Resultado riscoAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
}
