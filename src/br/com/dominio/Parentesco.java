package br.com.dominio;

public enum Parentesco {
	FILHO("Filho(a)"), CONJUGE("Conjuge");
	
	private final String descricao;
	
	private Parentesco(String description){
		this.descricao = description;
	}
	
	public String getDescription() {
		return this.descricao;
	}
}
