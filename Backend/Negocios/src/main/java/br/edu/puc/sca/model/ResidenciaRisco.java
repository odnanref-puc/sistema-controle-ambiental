package br.edu.puc.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResidenciaRisco{
	
	@Id
	@GeneratedValue
    private Long id;
    private String endereco;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private Integer unidade_exploracao_id;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getUnidade_exploracao_id() {
        return unidade_exploracao_id;
    }

    public void setUnidade_exploracao_id(Integer unidade_exploracao_id) {
        this.unidade_exploracao_id = unidade_exploracao_id;
    }

    @Override
    public String toString() {
        return "ResidenciaRisco [bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", endereco=" + endereco
                + ", estado=" + estado + ", id=" + id + ", numero=" + numero + ", pais=" + pais
                + ", unidade_exploracao_id=" + unidade_exploracao_id + "]";
    }
}