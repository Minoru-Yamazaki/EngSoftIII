package br.com.dominio;

import java.util.Date;

public abstract class Tipo extends EntidadeDominio {

	protected String nome;
	protected String descricao;

	public Tipo() {	}

	public Tipo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Tipo(String nome, String descricao, Date dataCadastro) {
		super(dataCadastro);
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
