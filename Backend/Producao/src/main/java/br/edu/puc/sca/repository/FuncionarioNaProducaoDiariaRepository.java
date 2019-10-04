package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.FuncionarioNaProducaoDiaria;

@Repository
public interface FuncionarioNaProducaoDiariaRepository extends JpaRepository<FuncionarioNaProducaoDiaria, FuncionarioNaProducaoDiaria.Id>{
}
