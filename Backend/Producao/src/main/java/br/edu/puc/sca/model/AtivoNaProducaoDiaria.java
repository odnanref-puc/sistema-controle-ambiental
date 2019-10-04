package br.edu.puc.sca.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AtivoNaProducaoDiaria{
	
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
		
	    private Long ativo_id;
	    private Long producao_diaria_id;

		public Id() {
			super();
		}
		
		public Id(Long producao_diaria_id) {
			super();
			this.producao_diaria_id = producao_diaria_id;
		}
		
		public Id(Long ativo_id, Long producao_diaria_id) {
			super();
			this.ativo_id = ativo_id;
			this.producao_diaria_id = producao_diaria_id;
		}

		public Long getAtivo_id() {
			return ativo_id;
		}
		
		public void setAtivo_id(Long ativo_id) {
			this.ativo_id = ativo_id;
		}
		
		public Long getProducao_diaria_id() {
			return producao_diaria_id;
		}
		
		public void setProducao_diaria_id(Long producao_diaria_id) {
			this.producao_diaria_id = producao_diaria_id;
		}

		@Override
		public String toString() {
			return "Id [ativo_id=" + ativo_id + ", producao_diaria_id=" + producao_diaria_id + "]";
		}
	}

	@Override
	public String toString() {
		return "AtivoNaProducaoDiaria [" + id.toString() + "]";
	}	
}


