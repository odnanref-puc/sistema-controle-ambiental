package br.edu.puc.sca.retorno;

public class Mensagem{
    private Integer codigo;
    private String descricao;
    
    public Mensagem() {}  
    
    public Mensagem(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }  

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}