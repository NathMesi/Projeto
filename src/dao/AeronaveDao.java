package dao;

import java.sql.SQLException;

import model.AeronaveModel;
import model.AeronaveModelView;
import model.AeronaveModelViewTo;
import model.TipoAeronaveModel;
import model.TipoAeronaveTo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class AeronaveDao {

	public AeronaveModelViewTo buscarTodosAmv() {

		String sqlSelect = "SELECT a.id_aeronave, a.id_tipo, a.nome, a.qtd_assentos, a.fileira, a.coluna, "
				+ "t.id_tipo, t.nome "
				+ "from aeronave as a "
				+ "inner join tipo_aeronave as t " + "on a.id_tipo = t.id_tipo";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		AeronaveModelViewTo to = new AeronaveModelViewTo();
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();

			while (rs.next()) {
				AeronaveModel aero = new AeronaveModel();
				aero.setIdAeronave(rs.getInt(1));
				aero.setIdTipo(rs.getInt(2));
				aero.setNome(rs.getString(3));
				aero.setQtdAssentos(rs.getInt(4));
				aero.setFileira(rs.getInt(5));
				aero.setColuna(rs.getInt(6));

				TipoAeronaveModel tipo = new TipoAeronaveModel();
				tipo.setIdTipo(rs.getInt(7));
				tipo.setNome(rs.getString(8));

				AeronaveModelView amv = new AeronaveModelView();
				amv.setAero(aero);
				amv.setTipo(tipo);

				to.add(amv);
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

	public boolean cadastrarAeronave(AeronaveModel aero) {

		String sql = "INSERT INTO aeronave(id_tipo, nome, qtd_assentos, fileira, coluna)"
				+ " VALUES(?,?,?,?,?)";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, aero.getIdTipo());
			stmt.setString(2, aero.getNome());
			stmt.setInt(3, aero.getQtdAssentos());
			stmt.setInt(4, aero.getFileira());
			stmt.setInt(5, aero.getColuna());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException u) {
			return false;
		}
	}
	
	public boolean editarAeronave(AeronaveModel aero) {

		String sql = "update aeronave set "
				+ "nome = ?, qtd_assentos = ?, fileira = ?, coluna = ? "
				+ " where id_aeronave = ?";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setString(1, aero.getNome());
			stmt.setInt(2, aero.getQtdAssentos());
			stmt.setInt(3, aero.getFileira());
			stmt.setInt(4, aero.getColuna());
			stmt.setInt(5, aero.getIdAeronave());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException u) {
			return false;
		}
	}

	public AeronaveModelView buscarAmvId(int id){
		String sqlSelect = "SELECT a.id_aeronave, a.id_tipo, a.nome, a.qtd_assentos, a.fileira, a.coluna, "
				+ "t.id_tipo, t.nome "
				+ "from aeronave as a "
				+ "inner join tipo_aeronave as t " + "on a.id_tipo = t.id_tipo "
						+ "where a.id_aeronave = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		AeronaveModelView amv = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			rs = (ResultSet) stm.executeQuery();

			while (rs.next()) {
				AeronaveModel aero = new AeronaveModel();
				aero.setIdAeronave(rs.getInt(1));
				aero.setIdTipo(rs.getInt(2));
				aero.setNome(rs.getString(3));
				aero.setQtdAssentos(rs.getInt(4));
				aero.setFileira(rs.getInt(5));
				aero.setColuna(6);

				TipoAeronaveModel tipo = new TipoAeronaveModel();
				tipo.setIdTipo(rs.getInt(7));
				tipo.setNome(rs.getString(8));

				amv = new AeronaveModelView();
				amv.setAero(aero);
				amv.setTipo(tipo);
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
		return amv;
	}

	public boolean excluirAeronave(int id){
		String sqlSelect = "delete from aeronave "
						+ "where id_aeronave = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			stm.execute();
			stm.close();
			
			return true;
			
		} catch (Exception e) {
			return false;

		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	// Tipo Aeronave

	/**
	 * Tipo Aeronave
	 * 
	 * @return
	 */
	public TipoAeronaveTo buscarTodosTipo() {
		String sqlSelect = "SELECT * FROM tipo_aeronave";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		TipoAeronaveTo to = new TipoAeronaveTo();
		TipoAeronaveModel tipo = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();

			while (rs.next()) {
				tipo = new TipoAeronaveModel();
				tipo.setIdTipo(rs.getInt(1));
				tipo.setNome(rs.getString(2));

				to.add(tipo);
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

}
