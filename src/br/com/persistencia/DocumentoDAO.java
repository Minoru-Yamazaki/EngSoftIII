package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import br.com.dominio.Documento;
import br.com.dominio.EntidadeDominio;
import br.com.util.Conexao;

public class DocumentoDAO implements IDAO {
	private Connection connection;
	private final int idPessoa;
	
	public DocumentoDAO(Connection connection, int idPessoa) {
		this.connection = connection;
		this.idPessoa = idPessoa;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		PreparedStatement pst=null;
		boolean ctrTransacao = false;
		
		Documento documento = (Documento) entidade;

		String colunas;

		if (documento.getPessoa().isCliente()) { 			
			colunas = "(doc_codigo, doc_validade, doc_tipo_nome, doc_tipo_descricao, doc_cli_id)";
		}else {
			colunas = "(doc_codigo, doc_validade, doc_tipo_nome, doc_tipo_descricao, doc_dep_id)";
		}

		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();	
				ctrTransacao = true;
			}	
			connection.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("documentos ");
			sql.append(colunas);
			sql.append(" VALUES (?,?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, documento.getCodigo());
			Timestamp time = new Timestamp(documento.getValidade().getTime());
			pst.setTimestamp(2, time);
			pst.setString(3, documento.getTipoDoc().getNome());
			pst.setString(4, documento.getTipoDoc().getDescricao());
			pst.setInt(5, idPessoa);
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				documento.setId(rs.getInt(1));

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
