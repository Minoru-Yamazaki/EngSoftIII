package br.com.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {

	private double credito = 0;
	private TipoCliente tipoCliente;
	private List<Dependente> dependentes;
	private List<Endereco> enderecos;
	
	public Cliente() {
		
	}

	public Cliente(Date dataCadastro, double credito, String nome, List<Documento> documentos, TipoCliente tipoCliente,
			List<Endereco> enderecos) {
		super(dataCadastro, nome, documentos);
		this.credito = credito;
		this.enderecos = enderecos;
		this.tipoCliente = tipoCliente;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		if (credito >= 1000) {
			this.credito = credito;
		} else {
			System.out.println("Crédito mínimo R$ 1000,00");
		}
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public void addDependentes(Dependente dependente) {
		if (dependentes == null) {
			dependentes = new ArrayList<Dependente>();
		}
		if (dependentes.size() < 2) {
			dependentes.add(dependente);
		} else {
			System.out.println("É possivel cadastrar somente 2 dependentes!");
		}
	}	

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void addEndereco(Endereco endereco) {
		if (enderecos == null) {
			enderecos = new ArrayList<Endereco>();
		}
		enderecos.add(endereco);
	}		
}
