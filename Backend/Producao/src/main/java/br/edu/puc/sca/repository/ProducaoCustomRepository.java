package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.ProducaoDiaria;
import br.edu.puc.sca.repository.custom.CustomRepository;

@Repository
public interface ProducaoCustomRepository extends JpaRepository<ProducaoDiaria, Long>, CustomRepository<ProducaoDiaria>{
}
