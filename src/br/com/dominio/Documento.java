package br.com.dominio;

import java.util.Date;

public class Documento extends EntidadeDominio{

	private TipoDocumento tipoDoc;
	private String codigo;
	private Date validade;
	private Pessoa pessoa;
	
	public Documento(TipoDocumento tipoDoc, String codigo, Date validade, Pessoa pessoa) {
		this.tipoDoc = tipoDoc;
		this.codigo = codigo;
		this.validade = validade;
		this.pessoa = pessoa;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
			
}
