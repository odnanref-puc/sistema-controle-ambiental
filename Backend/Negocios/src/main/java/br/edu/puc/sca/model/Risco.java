package br.edu.puc.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Risco{
	
	@Id
	@GeneratedValue
    private Long id;
    private String descricao;
    private String gravidade;
    private String impacto;
    private Double probabilidade;
    private String acao;
    private String situacao;
    private Integer unidade_exploracao_id;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public Double getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(Double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getUnidade_exploracao_id() {
        return unidade_exploracao_id;
    }

    public void setUnidade_exploracao_id(Integer unidade_exploracao_id) {
        this.unidade_exploracao_id = unidade_exploracao_id;
    }

    @Override
    public String toString() {
        return "Risco [acao=" + acao + ", descricao=" + descricao + ", gravidade=" + gravidade + ", id=" + id
                + ", impacto=" + impacto + ", probabilidade=" + probabilidade + ", situacao=" + situacao
                + ", unidade_exploracao_id=" + unidade_exploracao_id + "]";
    }
}