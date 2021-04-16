package br.com.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa extends EntidadeDominio{

	protected String nome;
	protected List<Documento> documentos;
	
	public Pessoa() {}
	
	public Pessoa(Date dataCadastro, String nome, List<Documento> documentos) {
		super(dataCadastro);
		this.nome = nome;
		this.documentos = documentos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
	public void addDocumento(Documento documento) {
		if (documentos == null) {
			documentos = new ArrayList<Documento>();
		}
		documentos.add(documento);
	}
	
	public boolean isCliente() {
		return (this instanceof Cliente);
	}
		
	
}
