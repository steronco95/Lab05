package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ricerca {

	Set<String> soluzione = new HashSet<>();
	
	
	/**
	 * inserisco in lista i valori trovati dalla ricorsione
	 * @param anagramma parola da anagrammare
	 * @return lista di tutti gli anagrammi trovati!
	 */
	public Set<String> anagrammi(String anagramma){
		
		List<Character> disponibili = new ArrayList<>();
		
		for(int i =0; i<anagramma.length(); i++) {
			disponibili.add(anagramma.charAt(i));
		}
		
		ricerca(0,"",disponibili);
		
		return soluzione;
	}
	
	void ricerca(int livello, String parziale,List<Character> disponibili) {
		
		if(disponibili.size()==0) {
			
			this.soluzione.add(parziale);
		
		}else {
			for(Character ch : disponibili) {
				
				String rimanenti = parziale + ch;
				
				List<Character> disp = new ArrayList<>(disponibili);
				disp.remove(ch);
				
				ricerca(livello+1,rimanenti,disp);
				
			}
		}
		
		
		
	}

	public void puliscitutto() {
		soluzione.clear();
		
	}
	
	
	
	
}
