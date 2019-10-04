package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.Pessoa;
import br.edu.puc.sca.repository.custom.CustomRepository;

@Repository
public interface PessoaCustomRepository extends JpaRepository<Pessoa, Long>, CustomRepository<Pessoa>{
}
