package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import br.com.dominio.Dependente;
import br.com.dominio.Documento;
import br.com.dominio.EntidadeDominio;
import br.com.util.Conexao;

public class DependenteDAO implements IDAO{
	private Connection connection;
	private final int idCliente;
	
	
	public DependenteDAO(Connection connection, int idCliente) {
		this.connection = connection;
		this.idCliente = idCliente;
	}
	@Override
	public void salvar(EntidadeDominio entidade) {
		Dependente dependente = (Dependente)entidade;
		PreparedStatement pst = null;
		boolean ctrTransacao = false;		
		
		try {			
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();	
				ctrTransacao = true;
			}
			connection.setAutoCommit(false);
						
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("dependentes(dep_nome, dep_data_cadastro, dep_tipo_nome, dep_tipo_descricao, dep_cli_id) ");
			sql.append("VALUES (?,?,?,?,?)");
					
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, dependente.getNome());
			Timestamp time = new Timestamp(dependente.getDataCadastro().getTime());
			pst.setTimestamp(2, time);	
			pst.setString(3, dependente.getTipoParentesco().getNome());
			pst.setString(4, dependente.getTipoParentesco().getDescricao());
			pst.setInt(5, idCliente);
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				dependente.setId(rs.getInt(1));		
			
			DocumentoDAO documentoDAO = new DocumentoDAO(connection, dependente.getId());
			for(Documento doc: dependente.getDocumentos()) {
				documentoDAO.salvar(doc);				
			}
						
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
