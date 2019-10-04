package br.edu.puc.sca.repository.custom;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.puc.sca.model.ProducaoDiaria;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProducaoCustomRepositoryImpl implements CustomRepository<ProducaoDiaria> {
    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<ProducaoDiaria> find(Long id, Date data) {
        Query query = entityManager.createNativeQuery("SELECT * FROM producao_diaria WHERE unidade_exploracao_id = ? and data = ?", ProducaoDiaria.class);
        query.setParameter(1, id);
        query.setParameter(2, data);
        
        return query.getResultList();
    }
       
    @SuppressWarnings("unchecked")
	@Override
    public List<ProducaoDiaria> find(Long id, Date data_inicial, Date data_final) {
        Query query = entityManager.createNativeQuery("SELECT * FROM producao_diaria WHERE unidade_exploracao_id = ? and data between ? and ?", ProducaoDiaria.class);
        query.setParameter(1, id);
        query.setParameter(2, data_inicial);
        query.setParameter(3, data_final);
        
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override    
    public List<ProducaoDiaria> find(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM producao_diaria WHERE unidade_exploracao_id = ?", ProducaoDiaria.class);
        query.setParameter(1, id);
        
        return query.getResultList();
    }
}


