package br.edu.puc.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.puc.sca.bean.SensorLastest;
import br.edu.puc.sca.repository.custom.CustomRepository;

@Repository
public interface SensorCustomRepository extends JpaRepository<SensorLastest, Long>, CustomRepository<SensorLastest>{
}
