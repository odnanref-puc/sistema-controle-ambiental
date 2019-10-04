package br.edu.puc.sca.repository.custom;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.puc.sca.model.AtivoNaProducaoDiaria;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AtivoCustomRepositoryImpl implements CustomRepository<AtivoNaProducaoDiaria> {
    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<AtivoNaProducaoDiaria> find(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM ativo_na_producao_diaria WHERE producao_diaria_id = ?", AtivoNaProducaoDiaria.class);
        query.setParameter(1, id);
        
        return query.getResultList();
    }
    
    public List<AtivoNaProducaoDiaria> find(Long id, Date data) {return null;}
    public List<AtivoNaProducaoDiaria> find(Long id, Date data_inicial, Date data_final) {return null;}
}


