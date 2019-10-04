package br.edu.puc.sca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ativo{
	
	@Id
	@GeneratedValue
    private Long id;
	private String nome;
    private String marca;
    private String modelo;
    private String descricao;
    private String fabricante;
    private Date data_aquisicao;
    private Double valor_aquisicao;
    private Integer tempo_garantia;
    private Integer vida_util;
    private Double valor_residual;
    private String situacao;
    private String tipo;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public Date getData_aquisicao() {
		return data_aquisicao;
	}
	
	public void setData_aquisicao(Date data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
	}
	
	public Double getValor_aquisicao() {
		return valor_aquisicao;
	}
	
	public void setValor_aquisicao(Double valor_aquisicao) {
		this.valor_aquisicao = valor_aquisicao;
	}
	
	public Integer getTempo_garantia() {
		return tempo_garantia;
	}
	
	public void setTempo_garantia(Integer tempo_garantia) {
		this.tempo_garantia = tempo_garantia;
	}
	
	public Integer getVida_util() {
		return vida_util;
	}
	
	public void setVida_util(Integer vida_util) {
		this.vida_util = vida_util;
	}
	
	public Double getValor_residual() {
		return valor_residual;
	}
	
	public void setValor_residual(Double valor_residual) {
		this.valor_residual = valor_residual;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Ativo [id=" + id + ", nome=" + nome + ", marca=" + marca + ", modelo=" + modelo + ", descricao="
				+ descricao + ", fabricante=" + fabricante + ", data_aquisicao=" + data_aquisicao + ", valor_aquisicao="
				+ valor_aquisicao + ", tempo_garantia=" + tempo_garantia + ", vida_util=" + vida_util
				+ ", valor_residual=" + valor_residual + ", situacao=" + situacao + "]";
	}
}