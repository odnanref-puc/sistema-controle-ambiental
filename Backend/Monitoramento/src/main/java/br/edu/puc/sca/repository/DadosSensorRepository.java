package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.puc.sca.model.DadosSensor;

@Repository
public interface DadosSensorRepository extends JpaRepository<DadosSensor, Long>{
}
