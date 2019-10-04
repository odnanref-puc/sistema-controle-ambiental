package br.edu.puc.sca.repository.custom;

import java.util.Date;
import java.util.List;

public interface CustomRepository<T> {
	List<T> find(Long id);
	List<T> find(Long id, Date data);
	List<T> find(Long id, Date data_inicial, Date data_final);
}
