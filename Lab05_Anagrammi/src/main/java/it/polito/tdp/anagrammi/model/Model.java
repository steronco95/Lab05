package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammiDAO.AnagrammaDAO;

public class Model {

	
	AnagrammaDAO ana = new AnagrammaDAO();
	Set<String> anagrammi = new HashSet<>();
	List<String> corretti = new LinkedList<>();
	List <String> errati = new LinkedList<>();	
	
	public void setAnagrammi (String anagramma){
		
		Ricerca ricerca = new Ricerca();
		ricerca.puliscitutto();
		
		if(anagramma.isEmpty()) throw new NullPointerException("non hai inserito nessuna parola");
		
		anagrammi = ricerca.anagrammi(anagramma);
		
		
	}
	
	
	public void verificaAnagrammi(){
		
		for(String s : anagrammi) {
			
			if(ana.anagrammaCorretto(s)) {
				corretti.add(s);
			}else {
				errati.add(s);
			}
		}
		
	}


	public String getCorretti() {
		StringBuffer result = new StringBuffer();
		
		for(String s : corretti) {
			result.append(s+ "\n");
		}
		
		return result.toString();
	}


	public String getErrati() {
		
		StringBuffer result = new StringBuffer();
		
		for(String s : errati) {
			result.append(s+ "\n");
		}
		
		return result.toString();
	}


	public void puliscitutto() {
		
		anagrammi.clear();
		corretti.clear();
		errati.clear();
		
		
	}
	
	
}
