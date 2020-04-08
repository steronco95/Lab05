package it.polito.tdp.anagrammiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammaDAO {
	
	public boolean anagrammaCorretto(String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome =?";

		try {
			boolean corretto = false;
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				corretto = true;
			
			}else {
				
				corretto = false;
			}
			conn.close();
					
			return corretto;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		
		
	}

}
