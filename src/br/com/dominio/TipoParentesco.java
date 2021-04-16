package br.com.dominio;

import java.util.Date;

public class TipoParentesco extends Tipo{

	public TipoParentesco(){}
	
	public TipoParentesco(Parentesco parentesco, String descricao) {
		super(parentesco.getDescription(), descricao);
	}
	
	public TipoParentesco(Parentesco parentesco, String descricao, Date dataCadastro){
		super(parentesco.getDescription(), descricao, dataCadastro);
	}
	
	
}
