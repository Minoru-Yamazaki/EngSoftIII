package br.com.dominio;

public class Endereco extends EntidadeDominio {

	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private TipoEndereco tipoEnd;
	private Cidade cidade;
	private Estado estado;
	private Pessoa pessoa;

	public Endereco(String logradouro, String numero, String cep, String complemento, TipoEndereco tipoEnd,
			Cidade cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.tipoEnd = tipoEnd;
		this.cidade = cidade;
		estado = cidade.getEstado();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public TipoEndereco getTipoEnd() {
		return tipoEnd;
	}

	public void setTipoEnd(TipoEndereco tipoEnd) {
		this.tipoEnd = tipoEnd;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
