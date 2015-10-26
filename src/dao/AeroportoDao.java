package dao;

import java.sql.SQLException;

import model.AeroportoModel;
import model.AeroportoTo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class AeroportoDao {

	public AeroportoTo buscarTodos() {

		String sqlSelect = "SELECT * from aeroporto";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		AeroportoTo to = new AeroportoTo();
		try {
			conn = new DataSource().obtemConexao();
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			rs = (ResultSet) stm.executeQuery();

			while (rs.next()) {
				AeroportoModel aero = new AeroportoModel();
				aero.setIdAeroporto(rs.getInt(1));
				aero.setNome(rs.getString(2));
				aero.setCidade(rs.getString(3));
				aero.setEstado(rs.getString(4));	
				
				to.add(aero);
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
