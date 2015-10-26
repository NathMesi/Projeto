package dao;

import java.sql.SQLException;

import model.AeronaveModel;
import model.AeronaveModelView;
import model.AeroportoModel;
import model.TipoAeronaveModel;
import model.TipoAeronaveTo;
import model.VooModel;
import model.VooModelView;
import model.VooModelViewTo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class VooDao {

	public VooModelViewTo buscarTodosVmv() {

		String sqlSelect = "SELECT v.id_voo, v.id_origem, v.id_destino, v.id_aeronave, v.datetime, v.status, v.valor, "
				+ "o.id_aeroporto, o.nome, o.cidade, o.estado, "
				+ "d.id_aeroporto, d.nome, d.cidade, d.estado, "
				+ "a.id_aeronave, a.id_tipo, a.nome, a.qtd_assentos, a.fileira, a.coluna, "
				+ "t.id_tipo, t.nome "
				+ "from voo as v "
				+ "inner join aeroporto as o "
				+ "on v.id_origem = o.id_aeroporto "
				+ "inner join aeroporto as d "
				+ "on v.id_destino = d.id_aeroporto "
				+ "inner join aeronave as a "
				+ "on v.id_aeronave = a.id_aeronave "
				+ "inner join tipo_aeronave as t "
				+ "on a.id_tipo = t.id_tipo";
		
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		VooModelViewTo to = new VooModelViewTo();
		
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();

			while (rs.next()) {
				VooModelView vmv = new VooModelView();
				VooModel voo = new VooModel();
				voo.setIdVoo(rs.getInt(1));
				voo.setIdOrigem(rs.getInt(2));
				voo.setIdDestino(rs.getInt(3));
				voo.setIdAeronave(rs.getInt(4));
				voo.setData(rs.getDate(5));
				voo.setStatus(rs.getString(6));
				voo.setPreco(rs.getDouble(7));
				
				AeroportoModel origem = new AeroportoModel();
				origem.setIdAeroporto(rs.getInt(8));
				origem.setNome(rs.getString(9));
				origem.setCidade(rs.getString(10));
				origem.setEstado(rs.getString(11));
				
				AeroportoModel destino = new AeroportoModel();
				destino.setIdAeroporto(rs.getInt(12));
				destino.setNome(rs.getString(13));
				destino.setCidade(rs.getString(14));
				destino.setEstado(rs.getString(15));
				
				AeronaveModel aero = new AeronaveModel();
				aero.setIdAeronave(rs.getInt(16));
				aero.setIdTipo(rs.getInt(17));
				aero.setNome(rs.getString(18));
				aero.setQtdAssentos(rs.getInt(19));
				aero.setFileira(rs.getInt(20));
				aero.setColuna(rs.getInt(21));

				TipoAeronaveModel tipo = new TipoAeronaveModel();
				tipo.setIdTipo(rs.getInt(22));
				tipo.setNome(rs.getString(23));

				AeronaveModelView amv = new AeronaveModelView();
				
				amv.setAero(aero);
				amv.setTipo(tipo);
				vmv.setAmv(amv);
				vmv.setOrigem(origem);
				vmv.setDestino(destino);
				vmv.setVoo(voo);

				to.add(vmv);
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

	public boolean cadastrarVoo(VooModel voo) {

		String sql = "INSERT INTO voo(id_origem, id_destino, id_aeronave, datetime, status, valor)"
				+ " VALUES(?,?,?,?,?,?)";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, voo.getIdOrigem());
			stmt.setInt(2, voo.getIdDestino());
			stmt.setInt(3, voo.getIdAeronave());
			stmt.setDate(4, voo.getData());
			stmt.setString(5, voo.getStatus());
			stmt.setDouble(6, voo.getPreco());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException u) {
			return false;
		}
	}
	
	public boolean editarVoo(VooModel voo) {

		String sql = "update voo set "
				+ "id_origem = ?, id_destino = ?, id_aeronave = ?, "
				+ "datetime = ?, status = ?, valor = ? "
				+ "where id_voo = ?";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, voo.getIdOrigem());
			stmt.setInt(2, voo.getIdDestino());
			stmt.setInt(3, voo.getIdAeronave());
			stmt.setDate(4, voo.getData());
			stmt.setString(5, voo.getStatus());
			stmt.setDouble(6, voo.getPreco());
			stmt.setInt(7, voo.getIdVoo());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException u) {
			return false;
		}
	}

	public VooModelView buscarVmvId(int id) {

		String sqlSelect = "SELECT v.id_voo, v.id_origem, v.id_destino, v.id_aeronave, v.datetime, v.status, v.valor, "
				+ "o.id_aeroporto, o.nome, o.cidade, o.estado, "
				+ "d.id_aeroporto, d.nome, d.cidade, d.estado, "
				+ "a.id_aeronave, a.id_tipo, a.nome, a.qtd_assentos, a.fileira, a.coluna, "
				+ "t.id_tipo, t.nome "
				+ "from voo as v "
				+ "inner join aeroporto as o "
				+ "on v.id_origem = o.id_aeroporto "
				+ "inner join aeroporto as d "
				+ "on v.id_destino = d.id_aeroporto "
				+ "inner join aeronave as a "
				+ "on v.id_aeronave = a.id_aeronave "
				+ "inner join tipo_aeronave as t "
				+ "on a.id_tipo = t.id_tipo "
				+ "where v.id_voo = ?";
		
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		VooModelView vmv = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			rs = (ResultSet) stm.executeQuery();

			if (rs.next()) {
				vmv = new VooModelView();
				VooModel voo = new VooModel();
				voo.setIdVoo(rs.getInt(1));
				voo.setIdOrigem(rs.getInt(2));
				voo.setIdDestino(rs.getInt(3));
				voo.setIdAeronave(rs.getInt(4));
				voo.setData(rs.getDate(5));
				voo.setStatus(rs.getString(6));
				voo.setPreco(rs.getDouble(7));
				
				AeroportoModel origem = new AeroportoModel();
				origem.setIdAeroporto(rs.getInt(8));
				origem.setNome(rs.getString(9));
				origem.setCidade(rs.getString(10));
				origem.setEstado(rs.getString(11));
				
				AeroportoModel destino = new AeroportoModel();
				destino.setIdAeroporto(rs.getInt(12));
				destino.setNome(rs.getString(13));
				destino.setCidade(rs.getString(14));
				destino.setEstado(rs.getString(15));
				
				AeronaveModel aero = new AeronaveModel();
				aero.setIdAeronave(rs.getInt(16));
				aero.setIdTipo(rs.getInt(17));
				aero.setNome(rs.getString(18));
				aero.setQtdAssentos(rs.getInt(19));
				aero.setFileira(rs.getInt(20));
				aero.setColuna(rs.getInt(21));

				TipoAeronaveModel tipo = new TipoAeronaveModel();
				tipo.setIdTipo(rs.getInt(22));
				tipo.setNome(rs.getString(23));

				AeronaveModelView amv = new AeronaveModelView();
				
				amv.setAero(aero);
				amv.setTipo(tipo);
				vmv.setAmv(amv);
				vmv.setOrigem(origem);
				vmv.setDestino(destino);
				vmv.setVoo(voo);
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
		return vmv;
	}

	public boolean excluirVoo(int id){
		String sqlSelect = "delete from voo "
						+ "where id_voo = ?";
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
