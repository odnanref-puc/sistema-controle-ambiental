package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.model.ResidenciaRisco;
import br.edu.puc.sca.repository.ResidenciaRiscoRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ResidenciaRiscoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    ResidenciaRiscoRepository repository;

    @RequestMapping("/residencia_risco/{id}")
    Resultado residenciaRiscoById(@PathVariable("id") int id){
        ResidenciaRisco residenciaRisco = repository.findOne(Long.valueOf(id));
        if(residenciaRisco == null)
            return new Resultado(1000, "Risco não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(residenciaRisco);

        return resultado;
    }

    @RequestMapping("/residencia_risco")
    Resultado residenciaRiscoAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
}
