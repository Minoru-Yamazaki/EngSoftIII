package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import br.com.dominio.Cliente;
import br.com.dominio.Dependente;
import br.com.dominio.Documento;
import br.com.dominio.Endereco;
import br.com.dominio.EntidadeDominio;
import br.com.util.Conexao;

public class ClienteDao implements IDAO{

	@Override
	public void salvar(EntidadeDominio entidade){
		Connection connection = null;
		PreparedStatement pst = null;
		Cliente cliente = (Cliente)entidade;
		
		try {
			connection = Conexao.getConnectionMySQL();
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("clientes(cli_nome, cli_credito, cli_data_cadastro, cli_tipo_nome, cli_tipo_descricao) ");
			sql.append("VALUES (?, ?, ?, ?, ?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getNome());
			pst.setDouble(2, cliente.getCredito());
			Timestamp time = new Timestamp(cliente.getDataCadastro().getTime());
			pst.setTimestamp(3, time);
			pst.setString(4, cliente.getTipoCliente().getNome());
			pst.setString(5, cliente.getTipoCliente().getDescricao());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				cliente.setId(rs.getInt(1));
			}

			DocumentoDAO docDAO = new DocumentoDAO(connection, cliente.getId());
			for(Documento documento : cliente.getDocumentos()) {
				docDAO.salvar(documento);
			}

			EnderecoDAO endDAO = new EnderecoDAO(connection, cliente.getId());
			for(Endereco endereco : cliente.getEnderecos()) {
				endDAO.salvar(endereco);
			}
			
			DependenteDAO depDAO = new DependenteDAO(connection, cliente.getId());
			for(Dependente dependente : cliente.getDependentes()) {
				depDAO.salvar(dependente);
			}
			
			connection.commit();
			
		} catch (SQLException | ClassNotFoundException e) { //  
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {							
				pst.close();
				connection.close();
				System.out.println("Cliente cadastrado com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	


	

}
