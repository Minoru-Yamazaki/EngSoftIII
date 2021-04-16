package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.dominio.Endereco;
import br.com.dominio.EntidadeDominio;
import br.com.util.Conexao;

public class EnderecoDAO implements IDAO{
	private Connection connection;
	private int idCliente;
	
	public EnderecoDAO(Connection connection, int idCliente) {
		this.connection = connection;
		this.idCliente = idCliente;
	}
	@Override
	public void salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		boolean ctrTransacao = false;
		
		Endereco endereco = (Endereco)entidade;
		
		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();
				ctrTransacao = true;
			}
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("enderecos(end_logradouro, end_numero, end_cep, end_complemento, end_cidade, ");
			sql.append("end_tipo_nome, end_tipo_descricao, end_estado_sigla, end_estado_nome, end_cli_id) ");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, endereco.getLogradouro());
			pst.setString(2, endereco.getNumero());
			pst.setString(3, endereco.getCep());
			pst.setString(4, endereco.getComplemento());
			pst.setString(5, endereco.getCidade().getDescricao());
			pst.setString(6, endereco.getTipoEnd().getNome());
			pst.setString(7, endereco.getTipoEnd().getDescricao());
			pst.setString(8, endereco.getEstado().getSigla());
			pst.setString(9, endereco.getEstado().getDescricao());
			pst.setInt(10, idCliente);
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				endereco.setId(rs.getInt(1));

			if(ctrTransacao) {
				connection.commit();	
			}			

		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				if(ctrTransacao) {
					connection.close();
				}
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
