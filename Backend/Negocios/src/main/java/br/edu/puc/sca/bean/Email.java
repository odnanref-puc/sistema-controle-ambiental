package br.edu.puc.sca.bean;

public class Email {
	
    private Long mina_id;
    private String assunto;
    private String mensagem;
    private String remetente;
    private String destinatario;
    private String senha;
    
	public Long getMina_id() {
		return mina_id;
	}
	
	public void setMina_id(Long mina_id) {
		this.mina_id = mina_id;
	}
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Email [mina_id=" + mina_id + ", assunto=" + assunto + ", mensagem=" + mensagem + ", remetente="
				+ remetente + ", destinatario=" + destinatario + ", senha=" + senha + "]";
	}
}
