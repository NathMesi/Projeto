package dao;

import java.sql.SQLException;

import model.AeronaveModel;
import model.AeronaveModelView;
import model.AeroportoModel;
import model.PassagemModel;
import model.PassagemTo;
import model.Rel_Pass_Passg;
import model.TipoAeronaveModel;
import model.TipoAeronaveTo;
import model.VooModel;
import model.VooModelView;
import model.VooModelViewTo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class PassagemDao {

	
	public int buscarUltimoId(){
		
		String sqlSelect = "SELECT MAX(id_passagem) FROM passagem";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
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
		return 0;
	}
	
	public PassagemModel buscarId(int id){
		
		String sqlSelect = "SELECT * FROM passagem where id_passagem = ?;";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		PassagemModel passagem = null;
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			rs = (ResultSet) stm.executeQuery();

			if (rs.next()) {
				passagem = new PassagemModel();
				passagem.setIdPasagem(rs.getInt(1));
				passagem.setIdVoo(rs.getInt(2));
				passagem.setEmail(rs.getString(3));
				passagem.setCelular(rs.getString(4));
				passagem.setStatus(rs.getString(5));
				passagem.setFileira(rs.getInt(6));
				passagem.setColuna(rs.getInt(7));
				
				return passagem;
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
		return passagem;
	}
	
	public boolean cadastrarPassagem(PassagemModel passagem) {

		String sql = "INSERT INTO passagem(id_voo, email, celular, status, fileira, coluna)"
				+ " VALUES(?, ?, ?, ?, ?, ?);";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, passagem.getIdVoo());
			stmt.setString(2, passagem.getEmail());
			stmt.setString(3, passagem.getCelular());
			stmt.setString(4, passagem.getStatus());
			stmt.setInt(5, passagem.getFileira());
			stmt.setInt(6, passagem.getColuna());

			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException u) {
			return false;
		}
	}
	
	public boolean editarPassagem(PassagemModel passagem) {

		String sql = "update passagem set "
				+ "id_passagem = ?, id_voo = ?, email = ?, "
				+ "celular = ?, status = ?, fileira = ?, coluna = ? "
				+ "where id_passagem = ?";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, passagem.getIdPasagem());
			stmt.setInt(2, passagem.getIdVoo());
			stmt.setString(3, passagem.getEmail());
			stmt.setString(4, passagem.getCelular());
			stmt.setString(5, passagem.getStatus());
			stmt.setDouble(6, passagem.getFileira());
			stmt.setInt(7, passagem.getColuna());
			stmt.setInt(8, passagem.getIdPasagem());

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
	
	// Rel Passagem - Passageiro

	public boolean cadastrarRel(Rel_Pass_Passg rel) {

		String sql = "INSERT INTO rel_pass_passg(id_passagem, id_passageiro)"
				+ " VALUES(?, ?)";

		try {
			Connection conn = new DataSource().obtemConexao();
			PreparedStatement stmt = (PreparedStatement) conn
					.prepareStatement(sql);

			stmt.setInt(1, rel.getPassagem());
			stmt.setInt(2, rel.getPassageiro());

			stmt.execute();

			stmt.close();
			return true;

		} catch (SQLException u) {
			return false;
		}
	}
	

}
