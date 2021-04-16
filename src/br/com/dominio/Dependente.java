package br.com.dominio;

import java.util.Date;
import java.util.List;

public class Dependente extends Pessoa{
	
	private TipoParentesco tipoParentesco;
	
	public Dependente() {}
	
	public Dependente(Date dataCadastro, String nome, List<Documento> documentos, TipoParentesco tipoParentesco) {
		super(dataCadastro, nome, documentos);
		this.tipoParentesco = tipoParentesco;
	}

	public TipoParentesco getTipoParentesco() {
		return tipoParentesco;
	}

	public void setTipoParentesco(TipoParentesco tipoParentesco) {
		this.tipoParentesco = tipoParentesco;
	}
	
	
}
