package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	CorsoDAO dao;

	public Model() {
		super();
		dao = new CorsoDAO();
	}
	
	public List<Corso> getTuttiCorsi()
	{
		return  this.dao.getTuttiICorsi();
	
	}
	

}
