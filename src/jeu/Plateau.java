package jeu;

import affichage.Affichage;
import cases.CaseNormale;

public class Plateau {
	
	private int nbCases = 30;
	private CaseNormale caseDebut;
	private CaseNormale caseFin;
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie, Affichage affichage) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
		caseDebut = new CaseNormale(1, affichage);
		caseFin = new CaseNormale(nbCases, affichage);
	}

	public int getNbCases() {
		return nbCases;
	}

	public CaseNormale getCaseFin() {
		return caseFin;
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
	
	
}
