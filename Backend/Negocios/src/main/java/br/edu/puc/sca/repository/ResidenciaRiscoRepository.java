package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.ResidenciaRisco;

@Repository
public interface ResidenciaRiscoRepository extends JpaRepository<ResidenciaRisco, Long>{
}
