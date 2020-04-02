package it.polito.tdp.lab04;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

// il fatto che non si scelga nessun corso nello specifico vuol dire che bisogna stamparli tutti o inviare un messaggio di errore?
// a cosa serve il metodo getcorso
public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Corso> choiceBox;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCompletamentoAutomatico;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscritti;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void CancellaTuttiCampi(ActionEvent event) {
    	this.txtCognome.clear();
    	this.txtMatricola.clear();
    	this.txtNome.clear();
    	this.txtResult.clear();
    
    

    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	
    	String matricola = this.txtMatricola.getText();
    	
    	if(matricola.contentEquals(""))
    	{
    		  txtResult.setText("Inserire la matricola di  uno studente\n");
    	        return;
    	} //parola.matches("[a-zA-Z]*")
    	if(!matricola.matches("[0-9]*")) 
    	{
    		 txtResult.setText("Caratteri in matricola non consentiti\n");
 	        return;
    	}

        Studente s =	this.model.getStudenteMatricola(matricola);
        if(s == null)
        {
        txtResult.setText("Studente non presente nel db\n");
        return;
        }
  
   List<Corso> corsi = this.model.getCorsiPerStudente(s);
   for(Corso c : corsi)
   {
	   txtResult.appendText(c.toStringTot());
   }
    	

    }

    @FXML
    void handleCercaIscrittiCorso(ActionEvent event) {
    String nomeCorso = 	choiceBox.getValue().getCorso();
    if(nomeCorso==null)
    {
    	txtResult.setText("Selezionare un corso!\n");
        return;
    }

    if(nomeCorso.equals(""))
    {
    	txtResult.setText("Selezionare un corso specifico!\n");
        return;
    }
    Corso c = this.choiceBox.getValue();
 for(Studente s :  this.model.getStudentiPerCorso(c))
 {
	 txtResult.appendText(s.toString());
 }


    }

    
    void handleChooseCorso() {
    	
    	if( model.getTuttiCorsi() == null)
    	{
    		System.out.print("Errore inserimento corsi\n");
    		return;
    	}
    	List<Corso> list = model.getTuttiCorsi();
    	Corso vuoto = new Corso();
    	list.add(vuoto);
    	this.choiceBox.getItems().addAll(list);
    	
    }

    @FXML
    void handleCompletamentoAutomatico(ActionEvent event) {
    	
    	
    	String matricola = this.txtMatricola.getText();
    	if(matricola.contentEquals(""))
    	{
    		  txtResult.setText("Inserire la matricola di  uno studente\n");
    	        return;
    	}
    	if(!matricola.matches("[0-9]*")) 
    	{
    		 txtResult.setText("Caratteri in matricola non consentiti\n");
 	        return;
    	}
        Studente s =	this.model.getStudenteMatricola(matricola);
        if(s == null)
        {
        txtResult.setText("Studente non presente nel db\n");
        return;
        }
 
    	this.txtNome.setText(s.getNome());
    	this.txtCognome.setText(s.getCognome());
    	

    }

    @FXML
    void handleIscritti(ActionEvent event) {
    	String matricola = this.txtMatricola.getText();
    	if(matricola.contentEquals(""))
    	{
    		  txtResult.setText("Selezionare uno studente\n");
    	        return;
    	}
    	if(!matricola.matches("[0-9]*")) 
    	{
    		 txtResult.setText("Caratteri in matricola non consentiti\n");
 	        return;
    	}
        Studente s =	this.model.getStudenteMatricola(matricola);
        if(s == null)
        {
        txtResult.setText("Studente non presente nel db\n");
        return;
        }
        
        String nomeCorso = 	choiceBox.getValue().getCorso();
       
        if(nomeCorso.equals(""))
        {
        	txtResult.setText("Selezionare un corso!\n");
            return;
        }
        Corso c = this.model.getTuttiCorsi().stream().filter(ss-> ss.getCorso().equals(nomeCorso)).findFirst().get();
        
       if( this.model.getCorsiPerStudente(s).contains(c))
       {
    	   txtResult.setText("Studente già iscritto al corso\n");
    	   return;
       }
       else
       {	 //iscrivi studente al corso
    	   
       }

       
       
    }

    @FXML
    void initialize() {
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompletamentoAutomatico != null : "fx:id=\"btnCompletamentoAutomatico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscritti != null : "fx:id=\"btnIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m)
    {
    	this.model=m;
    	handleChooseCorso();
    	
    
    }
}