package it.polito.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class ParolaDAO {
	
	public boolean parolaContenuta(String parola) {

		final String sql = "SELECT * FROM parola WHERE nome = ?";
		boolean ris=false;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				ris = true;	
			}

			conn.close();
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return ris;
	}


}
