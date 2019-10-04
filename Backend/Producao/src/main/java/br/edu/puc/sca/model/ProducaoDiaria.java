package br.edu.puc.sca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProducaoDiaria{
	
	@Id
	@GeneratedValue
    private Long id;
    private Date data;
    private String minerio;    
    private Double qde_etapa_extracao;
    private Double qde_etapa_britagem;
    private Double qde_etapa_classificacao;
    private Double qde_etapa_remocao_rejeitos;
    private Double qde_etapa_estocagem;
    private Double qde_etapa_carregamento;
    private Double qde_etapa_embarque;  
    private Integer unidade_exploracao_id;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getMinerio() {
		return minerio;
	}
	
	public void setMinerio(String minerio) {
		this.minerio = minerio;
	}
	
	public Double getQde_etapa_extracao() {
		return qde_etapa_extracao;
	}
	
	public void setQde_etapa_extracao(Double qde_etapa_extracao) {
		this.qde_etapa_extracao = qde_etapa_extracao;
	}
	
	public Double getQde_etapa_britagem() {
		return qde_etapa_britagem;
	}
	
	public void setQde_etapa_britagem(Double qde_etapa_britagem) {
		this.qde_etapa_britagem = qde_etapa_britagem;
	}
	
	public Double getQde_etapa_classificacao() {
		return qde_etapa_classificacao;
	}
	
	public void setQde_etapa_classificacao(Double qde_etapa_classificacao) {
		this.qde_etapa_classificacao = qde_etapa_classificacao;
	}
	
	public Double getQde_etapa_remocao_rejeitos() {
		return qde_etapa_remocao_rejeitos;
	}
	
	public void setQde_etapa_remocao_rejeitos(Double qde_etapa_remocao_rejeitos) {
		this.qde_etapa_remocao_rejeitos = qde_etapa_remocao_rejeitos;
	}
	
	public Double getQde_etapa_estocagem() {
		return qde_etapa_estocagem;
	}
	
	public void setQde_etapa_estocagem(Double qde_etapa_estocagem) {
		this.qde_etapa_estocagem = qde_etapa_estocagem;
	}
	
	public Double getQde_etapa_carregamento() {
		return qde_etapa_carregamento;
	}
	
	public void setQde_etapa_carregamento(Double qde_etapa_carregamento) {
		this.qde_etapa_carregamento = qde_etapa_carregamento;
	}
	
	public Double getQde_etapa_embarque() {
		return qde_etapa_embarque;
	}
	
	public void setQde_etapa_embarque(Double qde_etapa_embarque) {
		this.qde_etapa_embarque = qde_etapa_embarque;
	}
	
	public Integer getUnidade_exploracao_id() {
		return unidade_exploracao_id;
	}
	
	public void setUnidade_exploracao_id(Integer unidade_exploracao_id) {
		this.unidade_exploracao_id = unidade_exploracao_id;
	}
	
	@Override
	public String toString() {
		return "ProducaoDiaria [id=" + id + ", data=" + data + ", minerio=" + minerio + ", qde_etapa_extracao="
				+ qde_etapa_extracao + ", qde_etapa_britagem=" + qde_etapa_britagem + ", qde_etapa_classificacao="
				+ qde_etapa_classificacao + ", qde_etapa_remocao_rejeitos=" + qde_etapa_remocao_rejeitos
				+ ", qde_etapa_estocagem=" + qde_etapa_estocagem + ", qde_etapa_carregamento=" + qde_etapa_carregamento
				+ ", qde_etapa_embarque=" + qde_etapa_embarque + ", unidade_exploracao_id=" + unidade_exploracao_id
				+ "]";
	}
}