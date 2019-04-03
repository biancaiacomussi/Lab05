package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.anagrammi.dao.ParolaDAO;


public class Model {
	
	private List<String> giuste;
	private List<String> sbagliate;
	
	
	
	public List<String> getGiuste() {
		return giuste;
	}

	public List<String> getSbagliate() {
		return sbagliate;
	}

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
		ParolaDAO dao = new ParolaDAO();
		
		if(parziale.getSizeMax()==level) {
			if(dao.parolaContenuta((parziale.parolaInserita())))
				giuste.add(parziale.parolaInserita());
			else
				sbagliate.add(parziale.parolaInserita()); //clone
			return;
		}
		
		for(int i=0; i<parziale.getSizeMax(); i++) {
			parziale.add(parziale.getCaratteriPossibili().get(i));
			
			if(parziale.possoInserire(parziale.getCaratteriPossibili().get(i)))
				recursive(parziale, level+1);
			
			parziale.remove(parziale.getCaratteriPossibili().get(i));
		}
		
		
		
	}

}
