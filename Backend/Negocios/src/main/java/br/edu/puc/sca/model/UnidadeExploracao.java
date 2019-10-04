package br.edu.puc.sca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidadeExploracao {
	@Id
	@GeneratedValue
    private Long id;
    private String nome;
    private String latitude;
    private String longitude;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private Date inicio_operacao;
    private Date fim_operacao;
    private String situacao;
    private Double capacidade_prevista;

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public Date getInicio_operacao() {
        return inicio_operacao;
    }

    public void setInicio_operacao(Date inicio_operacao) {
        this.inicio_operacao = inicio_operacao;
    }

    public Date getFim_operacao() {
        return fim_operacao;
    }

    public void setFim_operacao(Date fim_operacao) {
        this.fim_operacao = fim_operacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Double getCapacidade_prevista() {
        return capacidade_prevista;
    }

    public void setCapacidade_prevista(Double capacidade_prevista) {
        this.capacidade_prevista = capacidade_prevista;
    }

    @Override
    public String toString() {
        return "UnidadeExploracao [bairro=" + bairro + ", capacidade_prevista=" + capacidade_prevista + ", cidade="
                + cidade + ", estado=" + estado + ", fim_operacao=" + fim_operacao + ", id=" + id + ", inicio_operacao="
                + inicio_operacao + ", latitude=" + latitude + ", longitude=" + longitude + ", nome=" + nome + ", pais="
                + pais + ", situacao=" + situacao + "]";
    }
   
}
