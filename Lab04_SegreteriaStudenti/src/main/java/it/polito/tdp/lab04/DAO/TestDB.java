package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		cdao.getStudentiIscrittiAlCorso(new Corso("01KSUPG", 8, "Gestione dell'innovazione e sviluppo prodotto", 2));
		StudenteDAO daoS= new StudenteDAO();
		
		Studente s = daoS.getStudenteByMatricola("154817");
		System.out.print(s.toString());

		
	}

}
