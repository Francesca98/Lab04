package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
	String s = "1546638sertrytuyi8";
	if(s.matches("[a-zA-Z_0-9]*"))
	{
		System.out.print("it's ok\n");
	}
	else
	System.out.print("NO");
	

	}

}
