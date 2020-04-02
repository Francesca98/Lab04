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
		Corso c = cdao.getCorsoByCod(new Corso("01KSUPG", 0,null,0));
		System.out.print("Corso e :  "+c.toString());
		StudenteDAO daoS= new StudenteDAO();
		
		 daoS.getTuttiICorsiPerStudente(new Studente(null, null,  "154817"));
	

		
	}

}
