package it.polito.tdp.lab04.model;

public class Corso {
	private String codice;
	private int crediti ;
	private String corso;
	private int periodo ;
	
	
	public Corso(String codice, int crediti, String corso, int periodo) {
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.corso = corso;
		this.periodo = periodo;
	}

	public Corso() {

	}
	

	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public int getCrediti() {
		return crediti;
	}


	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}


	public String getCorso() {
		return corso;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public int getPeriodo() {
		return periodo;
	}


	public void setPeriodo(int periodo) {
		this.periodo = periodo;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corso : " + codice + ", " + crediti + ", " + corso + ", " + periodo + "\n";
	}

}