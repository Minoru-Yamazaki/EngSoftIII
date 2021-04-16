package br.com.dominio;

public class Cidade extends EntidadeDominio{

	private Estado estado;
	private String descricao;
	
	public Cidade(String descricao, Estado estado) {
		this.descricao = descricao;
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
