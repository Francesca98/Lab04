package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO cdao;
	StudenteDAO sdao;

	public Model() {
		super();
		cdao = new CorsoDAO();
		sdao= new StudenteDAO();
	}
	
	public List<Corso> getTuttiCorsi()
	{
		return  this.cdao.getTuttiICorsi();
	
	}
	
	public List<Corso> getCorsiPerStudente(Studente s)
	{
		return  this.sdao.getTuttiICorsiPerStudente(s);
	
	}
	public List<Studente> getStudentiPerCorso(Corso corso)
	{
		return  this.cdao.getStudentiIscrittiAlCorso(corso);
	
	}
	
	public Studente getStudenteMatricola(String matricola)
	{
		return sdao.getStudenteByMatricola(matricola);
	}
	
	

}
