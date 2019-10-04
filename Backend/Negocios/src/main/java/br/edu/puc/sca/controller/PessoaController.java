package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.puc.sca.model.Pessoa;
import br.edu.puc.sca.repository.PessoaCustomRepository;
import br.edu.puc.sca.repository.PessoaRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PessoaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    PessoaRepository repository;
    @Autowired
    PessoaCustomRepository customRepository;

    @RequestMapping("/pessoa/{id}")
    Resultado pessoaById(@PathVariable("id") int id){
        Pessoa pessoa = repository.findOne(Long.valueOf(id));
        if(pessoa == null)
            return new Resultado(1000, "Risco não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(pessoa);

        return resultado;
    }

    @RequestMapping("/pessoa")
    Resultado pessoaAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
    
    @RequestMapping("/pessoas_mina/{mina_id}")
    Resultado pessoasMina(@PathVariable("mina_id") int mina_id){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(customRepository.find(Long.valueOf(mina_id)));

       return resultado;
    }
}
