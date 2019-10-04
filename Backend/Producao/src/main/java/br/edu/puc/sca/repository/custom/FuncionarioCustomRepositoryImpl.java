package br.edu.puc.sca.repository.custom;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.puc.sca.model.FuncionarioNaProducaoDiaria;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FuncionarioCustomRepositoryImpl implements CustomRepository<FuncionarioNaProducaoDiaria> {
    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<FuncionarioNaProducaoDiaria> find(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM funcionario_na_producao_diaria WHERE producao_diaria_id = ?", FuncionarioNaProducaoDiaria.class);
        query.setParameter(1, id);
        
        return query.getResultList();
    }
    
    public List<FuncionarioNaProducaoDiaria> find(Long id, Date data) {return null;}
    public List<FuncionarioNaProducaoDiaria> find(Long id, Date data_inicial, Date data_final) {return null;}
}


