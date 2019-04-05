package it.polito.tdp.anagrammi.model;


import java.util.LinkedList;
import java.util.List;

import it.polito.anagrammi.dao.ParolaDAO;


public class Model {
	
	private List<String> giuste;
	private List<String> sbagliate;
	private List<String> soluzioni;
	
	
	public List<String> getGiuste() {
		return giuste;
	}

	public List<String> getSbagliate() {
		return sbagliate;
	}

	public Model() {
		giuste = new LinkedList<String>();
		sbagliate = new LinkedList<String>();
		soluzioni = new LinkedList<String>();
	}
	
	public void genera(String input) {
		Anagramma parziale = new Anagramma(input);
		this.recursive(parziale, 0);
	}
	
	public void recursive(Anagramma parziale, int level) {
		
		if(parziale.getSizeMax()==level) {
			soluzioni.add(new String(parziale.parolaInserita()));
			
			return;
		}
		
		for(int i=0; i<parziale.getSizeMax(); i++) {
			Character c = parziale.getCaratteriPossibili().get(i);
			
			parziale.add(c);
			
			
			if(parziale.possoInserire(c)) {
				parziale.removePossibili(c);
				recursive(parziale, level+1);
			}
			
			parziale.remove(c);
			parziale.addPossibili(c);
			
		}
		
	}
	
	public void aggiungi() {
		ParolaDAO dao = new ParolaDAO();
		for(String s: soluzioni) {
			
			if(dao.parolaContenuta(s))
				giuste.add(s);
			else
				sbagliate.add(s);
			
		}
		
	}

}
