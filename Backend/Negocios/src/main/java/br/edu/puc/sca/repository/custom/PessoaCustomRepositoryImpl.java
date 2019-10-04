package br.edu.puc.sca.repository.custom;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.puc.sca.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PessoaCustomRepositoryImpl implements CustomRepository<Pessoa> {
    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Pessoa> find(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM Pessoa WHERE unidade_exploracao_id = ?", Pessoa.class);
        query.setParameter(1, id);
        
        return query.getResultList();
    }

}


