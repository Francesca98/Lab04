package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	
	
	public Studente  getStudenteByMatricola(String matricola) {

		final String sql = "SELECT * FROM  studente where matricola = ? ";

		Studente studente = null;

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










public List<Corso> getTuttiICorsiPerStudente(Studente s ) {

	
	String sql = "select c.codins, c.nome, c.crediti, c.pd " + 
			"from corso as c, iscrizione as i " + 
			"where c.codins = i.codins and i.matricola = ? " ;

	List<Corso> corsi = new LinkedList<Corso>();

	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, s.getMatricola());

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			String codins = rs.getString("c.codins");
			int numeroCrediti = rs.getInt("c.crediti");
			String nome = rs.getString("c.nome");
			int periodoDidattico = rs.getInt("c.pd");

			System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

			// Crea un nuovo JAVA Bean Corso
			Corso corso = new Corso(codins, numeroCrediti, nome, periodoDidattico);
			
			// Aggiungi il nuovo oggetto Corso alla lista corsi
			corsi.add(corso);
		}

		conn.close();
		
		return corsi;
		

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
}
}