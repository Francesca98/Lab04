package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	
	
	public Studente  getStudenteByMatricola(String matricola) {

		final String sql = "SELECT * FROM  studente where matricola = ? ";

		Studente studente = new Studente();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
			
				String cognome = rs.getString("cognome");
		
				


				// Crea un nuovo JAVA Bean Corso
				 studente = new Studente(nome, cognome, matricola);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				
			}

			conn.close();
			
			return  studente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
