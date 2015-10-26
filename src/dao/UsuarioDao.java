package dao;

import java.sql.SQLException;

import model.UsuarioModel;
import model.UsuarioTo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class UsuarioDao {
	
	public UsuarioTo carregarTodos() {

		String sqlSelect = "SELECT * FROM usuario";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		UsuarioTo to = new UsuarioTo();
		UsuarioModel usuario = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();
			
			while (rs.next()) {
				usuario = new UsuarioModel();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setIdTipo(rs.getInt(2));
				usuario.setNome(rs.getString(3));
				usuario.setUsuario(rs.getString(4));
				usuario.setSenha(rs.getString(5));

				to.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return to;
	}
	
	public UsuarioModel logar(String login, String senha){
		
		String sqlSelect = "SELECT * FROM usuario "
				+ "where usuario = ? "
				+ "and senha = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		UsuarioModel usuario = null;
		try {
			conn = new DataSource().obtemConexao();
			
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setString(1, login);
			stm.setString(2, senha);
			rs = (ResultSet) stm.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioModel();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setIdTipo(rs.getInt(2));
				usuario.setNome(rs.getString(3));
				usuario.setUsuario(rs.getString(4));
				usuario.setSenha(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return usuario;
	}
}
