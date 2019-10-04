package br.edu.puc.sca.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SensorLastest{
	
	@Id
    private Long id;
    private String situacao;
    private String unidade_exploracao_id;
    private Double temperatura;
    private Double pressao;
    
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
	
	public String getUnidade_exploracao_id() {
		return unidade_exploracao_id;
	}
	
	public void setUnidade_exploracao_id(String unidade_exploracao_id) {
		this.unidade_exploracao_id = unidade_exploracao_id;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	public Double getPressao() {
		return pressao;
	}
	
	public void setPressao(Double pressao) {
		this.pressao = pressao;
	} 
}