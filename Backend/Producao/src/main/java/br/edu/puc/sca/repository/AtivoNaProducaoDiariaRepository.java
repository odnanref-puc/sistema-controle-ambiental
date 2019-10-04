package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.AtivoNaProducaoDiaria;

@Repository
public interface AtivoNaProducaoDiariaRepository extends JpaRepository<AtivoNaProducaoDiaria, AtivoNaProducaoDiaria.Id>{
}
