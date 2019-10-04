package br.edu.puc.sca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa{
	
	@Id
	@GeneratedValue
    private Long id;
    private String documento;
    private String nome;
    private Date nascimento;
    private String email;
    private String telefone;
    private String pais;
    private String cep;
    private Integer residencia_risco_id;
    private Integer unidade_exploracao_id;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public Integer getResidencia_risco_id() {
        return residencia_risco_id;
    }

    public void setResidencia_risco_id(Integer residencia_risco_id) {
        this.residencia_risco_id = residencia_risco_id;
    }

    public Integer getUnidade_exploracao_id() {
        return unidade_exploracao_id;
    }

    public void setUnidade_exploracao_id(Integer unidade_exploracao_id) {
        this.unidade_exploracao_id = unidade_exploracao_id;
    }

    @Override
    public String toString() {
        return "Pessoa [cep=" + cep + ", documento=" + documento + ", email=" + email + ", id=" + id + ", nascimento="
                + nascimento + ", nome=" + nome + ", pais=" + pais + ", residencia_risco_id=" + residencia_risco_id
                + ", telefone=" + telefone + ", unidade_exploracao_id=" + unidade_exploracao_id + "]";
    }
}