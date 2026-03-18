package jeu;

import affichage.Affichage;
import cases.*;

public class Plateau {
	
	private static final int NBCASES = 30;
	private Case[] cases = new Case[NBCASES];
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	private Integer[] posCaseEchange;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie, Integer[] posCaseEchange, Affichage affichage) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
		this.posCaseEchange = posCaseEchange;
		
		for (int i=0 ; i<NBCASES ; i++) {
			if (verifierCaseRouletteRusse(i+1)) {
				cases[i] = new CaseRouletteRusse(affichage);
			} else if (verifierCaseVolVie(i+1)){
				cases[i] = new CaseVolVie(affichage);
			} else if (verifierCaseEchange(i+1)) {
				cases[i] = new CaseEchange(affichage);
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
	
	private boolean verifierCaseEchange(int positionCase) {
		for (int i=0 ; i<posCaseEchange.length ; i++) {
			if (posCaseEchange[i] == positionCase) {
				return true;
			}
		}
		return false;
	}
	
	public int getNbCases() {
		return NBCASES;
	}
	
	public Case getCase(int numeroCase) {
		return cases[numeroCase];
	}
}
