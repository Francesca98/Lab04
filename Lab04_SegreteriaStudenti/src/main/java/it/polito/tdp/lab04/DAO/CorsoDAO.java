package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

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
	
	
	
	public Corso  getCorsoByCod(Corso corso) {

		final String sql = "SELECT * FROM  corso where codins = ? ";

		Corso c = null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1, corso.getCodice());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
				 int periodo = rs.getInt("pd");
			
				 int crediti = rs.getInt("crediti");
			
		
				


				 c = new Corso(corso.getCodice(), crediti, nome, periodo);
				
			}

			conn.close();
			
			return  c;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	
	
	
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		List<Studente> stud = new LinkedList<>();
		String sql = "select *" + 
				"from corso as c, iscrizione as i, studente as s " + 
				"where c.codins = i.codins and i.matricola = s.matricola and c.nome = ? " ;
			

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
st.setString(1, corso.getCorso());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("s.nome");
				String matricola = rs.getString("matricola");
				String cognome = rs.getString("cognome");
		
				


				// Crea un nuovo JAVA Bean Corso
				Studente studente = new Studente(nome, cognome, matricola);
				System.out.print(studente.toString());
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				stud.add(studente);
			}

			conn.close();
	
			
			return stud;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
//	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
//		String sql = ;
//		
//		
//		try {
//			Connection conn = ConnectDB.getConnection();
//			PreparedStatement st = conn.prepareStatement(sql);
//
//			ResultSet rs = st.executeQuery();
//
//			while (rs.next()) {
//
//			}
//
//			conn.close();
//	
//			
//			return stud;
//			
//
//		} catch (SQLException e) {
//			// e.printStackTrace();
//			throw new RuntimeException("Errore Db", e);
//		}
//
//		return false;
//	}

}
