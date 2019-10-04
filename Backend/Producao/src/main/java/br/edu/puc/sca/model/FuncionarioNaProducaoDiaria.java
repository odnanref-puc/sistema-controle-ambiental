package br.edu.puc.sca.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class FuncionarioNaProducaoDiaria{
	
	@EmbeddedId Id id;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
	@Embeddable	
	public static class Id implements Serializable{
		private static final long serialVersionUID = 1L;
		
	    private Long funcionario_id;
	    private Long producao_diaria_id;
	    
		public Id() {
			super();
		}
	    
		public Id(Long funcionario_id, Long producao_diaria_id) {
			super();
			this.funcionario_id = funcionario_id;
			this.producao_diaria_id = producao_diaria_id;
		}

		public Long getFuncionario_id() {
			return funcionario_id;
		}
		
		public void setFuncionario_id(Long funcionario_id) {
			this.funcionario_id = funcionario_id;
		}
		
		public Long getProducao_diaria_id() {
			return producao_diaria_id;
		}
		
		public void setProducao_diaria_id(Long producao_diaria_id) {
			this.producao_diaria_id = producao_diaria_id;
		}
	}
}


