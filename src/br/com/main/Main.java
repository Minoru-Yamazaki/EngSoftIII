package br.com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.dominio.Cidade;
import br.com.dominio.Cliente;
import br.com.dominio.Dependente;
import br.com.dominio.Documento;
import br.com.dominio.Endereco;
import br.com.dominio.Estado;
import br.com.dominio.Parentesco;
import br.com.dominio.TipoCliente;
import br.com.dominio.TipoDocumento;
import br.com.dominio.TipoEndereco;
import br.com.dominio.TipoParentesco;
import br.com.persistencia.ClienteDao;

public class Main {

	public static void main(String[] args) {

		TipoDocumento tpDocRg = new TipoDocumento();
		tpDocRg.setDescricao("REGISTRO GERAL");
		tpDocRg.setNome("RG");

		TipoDocumento tpDocCpf = new TipoDocumento();
		tpDocCpf.setDescricao("Cadastro Pessoa Física");
		tpDocCpf.setNome("CPF");

		Documento rg = new Documento(tpDocRg, "35943167-8", new Date(), new Cliente());

		List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(rg);

		Documento cpfDep = new Documento(tpDocCpf, "463259713-85", new Date(), new Dependente());

		List<Documento> docDep = new ArrayList<Documento>();
		docDep.add(cpfDep);

		TipoCliente tpClienteVip = new TipoCliente("Normal", "Cliente que compra regularmente!");

		TipoEndereco tpEnd = new TipoEndereco("residencial", "Endereço endereço onde mora");

		Estado estado = new Estado("São Paulo", "SP");

		Cidade cidade = new Cidade("Mogi das Cruzes", estado);

		Endereco endMoradia = new Endereco("Rua ´três", "3", "48631-762", "Perto da rua Dois", tpEnd, cidade);

		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endMoradia);

		Cliente maria = new Cliente(new Date(), 1000, "Maria", documentos, tpClienteVip, enderecos);

		TipoDocumento tpDocCpfCli = new TipoDocumento("CPF", "CADASTRO DE PESSOA FISICA");

		Documento docCli = new Documento(tpDocCpfCli, "49316579554", new Date(), new Cliente());

		maria.addDocumento(docCli);

		TipoEndereco endTpRes = new TipoEndereco("Residencial", "Endereço Residencial");

		Cidade cidadeDois = new Cidade("Suzano", estado);

		Endereco endRes = new Endereco("Rua Dois", "2", "98765-432", "Complemento", endTpRes, cidadeDois);

		maria.addEndereco(endRes);

		TipoParentesco tpParent = new TipoParentesco(Parentesco.FILHO, "Filho caçula", new Date());

		Dependente depUm = new Dependente(new Date(), "Yoshio", docDep, tpParent);

		List<Dependente> dependentes = new ArrayList<>();

		dependentes.add(depUm);

		maria.setDependentes(dependentes);

		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.salvar(maria);
	}
}
