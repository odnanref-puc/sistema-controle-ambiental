package br.edu.puc.sca.repository.custom;

import java.util.List;

public interface CustomRepository<T> {
	List<T> findLastestAll();
}
