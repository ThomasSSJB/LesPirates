package jeu;

import affichage.Affichage;
import cases.*;

public class Plateau {
	
	private static final int nbCases = 30;
	private Case[] cases = new Case[nbCases];
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie, Affichage affichage) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
		
		for (int i=0 ; i<nbCases ; i++) {
			if (verifierCaseRouletteRusse(i+1)) {
				cases[i] = new CaseRouletteRusse(affichage);
			} else if (verifierCaseVolVie(i+1)){
				cases[i] = new CaseVolVie(affichage);
			} else {
				cases[i] = new CaseNormale(affichage);
			}
		}
	}
	
	public boolean verifierCaseRouletteRusse(int positionCase) {
		for (int i=0 ; i<posCaseRouletteRusse.length ; i++) {
			if (posCaseRouletteRusse[i] == positionCase) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifierCaseVolVie(int positionCase) {
		for (int i=0 ; i<posCaseVolVie.length ; i++) {
			if (posCaseVolVie[i] == positionCase) {
				return true;
			}
		}
		return false;
	}
	
	public int getNbCases() {
		return nbCases;
	}
	
	public Case getCase(int numeroCase) {
		return cases[numeroCase];
	}
}
