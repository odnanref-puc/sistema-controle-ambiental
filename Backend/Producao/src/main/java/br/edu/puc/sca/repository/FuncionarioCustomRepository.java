package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.FuncionarioNaProducaoDiaria;
import br.edu.puc.sca.repository.custom.CustomRepository;

@Repository
public interface FuncionarioCustomRepository extends JpaRepository<FuncionarioNaProducaoDiaria, FuncionarioNaProducaoDiaria.Id>, CustomRepository<FuncionarioNaProducaoDiaria>{
}
