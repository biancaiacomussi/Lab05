package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	private List<Character> caratteriPossibili;
	private List<Character> caratteriInseriti;
	private int sizeMax;
	private int size;
	
	
	public Anagramma(String input) {
		caratteriPossibili = new ArrayList<Character>();		
		
		caratteriInseriti = new ArrayList<Character>();
		this.setCaratteriPossibili(input);
		sizeMax = caratteriPossibili.size();
	}
	
	public void setCaratteriPossibili(String input) {
		for(char c : input.toCharArray())
		this.caratteriPossibili.add(c);
	}
	
	public int getSize() {
		return caratteriInseriti.size();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String parolaInserita() {
		String ris="";
		
		for(Character c : caratteriInseriti) {
			ris += ""+c+"";
		}
		
		return ris;
	}

	public List<Character> getCaratteriPossibili() {
		return caratteriPossibili;
	}


	public List<Character> getCaratteriInseriti() {
		return caratteriInseriti;
	}

	public int getSizeMax() {
		return sizeMax;
	}
	
		
	public void add(char n) {
		
		this.caratteriInseriti.add(n) ;
	
	}
	
	public void removePossibili(char c) {
		Character t = c;
		this.caratteriPossibili.remove(t);
	}
	
	public void addPossibili(char c) {
		this.caratteriPossibili.add(c);
	}
	
	public void remove(char c) {
		
		Character t = c;
		this.caratteriInseriti.remove(t);
	
	}
	
	public boolean possoInserire (char c) {
		return this.caratteriPossibili.contains(c);
	}
	

}
