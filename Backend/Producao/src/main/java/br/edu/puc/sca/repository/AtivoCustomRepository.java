package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.AtivoNaProducaoDiaria;
import br.edu.puc.sca.repository.custom.CustomRepository;

@Repository
public interface AtivoCustomRepository extends JpaRepository<AtivoNaProducaoDiaria, AtivoNaProducaoDiaria.Id>, CustomRepository<AtivoNaProducaoDiaria>{
}
