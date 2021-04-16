package br.com.dominio;

import java.util.Date;

public abstract class EntidadeDominio {

	protected int id;
	protected Date dataCadastro;
	
	public EntidadeDominio() {}
	
	public EntidadeDominio(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
