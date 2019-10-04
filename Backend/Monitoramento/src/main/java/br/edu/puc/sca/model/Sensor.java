package br.edu.puc.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sensor{
	
	@Id
	@GeneratedValue
    private Long id;
    private String situacao;
    private Long unidade_exploracao_id;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public Long getUnidade_exploracao_id() {
		return unidade_exploracao_id;
	}
	
	public void setUnidade_exploracao_id(Long unidade_exploracao_id) {
		this.unidade_exploracao_id = unidade_exploracao_id;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", situacao=" + situacao + ", unidade_exploracao_id=" + unidade_exploracao_id + "]";
	}
}