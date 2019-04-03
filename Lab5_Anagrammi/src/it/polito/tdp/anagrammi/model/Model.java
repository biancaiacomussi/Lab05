package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Model {
	
	List<String> giuste;
	List<String> sbagliate;
	
	public Model() {
		giuste = new LinkedList<String>();
		sbagliate = new LinkedList<String>();
	}
	
	public void genera(String input) {
		giuste = new LinkedList<String>();
		sbagliate = new LinkedList<String>();
		Anagramma parziale = new Anagramma(input);
		this.recursive(parziale, 0);
	}
	
	public void recursive(Anagramma parziale, int level) {
		
		if(parziale.getSizeMax()==level) {
			if(dizionario.contains(parziale.parolaInserita()))
				giuste.add(parziale.parolaInserita());
			else
				sbagliate.add(parziale.parolaInserita()); //clone
			return;
		}
		
		for(int i=0; i<parziale.getSizeMax(); i++) {
			parziale.add(parziale.getCaratteriPossibili().get(i));
		}
		
		
		
	}

}
