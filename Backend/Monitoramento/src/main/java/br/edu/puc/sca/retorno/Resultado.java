package br.edu.puc.sca.retorno;

public class Resultado{
    private Mensagem mensagem;
    private Object conteudo;
    
    public Resultado() {}

    public Resultado(Integer codigo, String descricao){
        this.mensagem = new Mensagem(codigo, descricao);
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Object getConteudo() {
        return conteudo;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }
}