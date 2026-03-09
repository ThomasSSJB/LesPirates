package jeu;

import cases.CaseNormale;

public class Plateau {
	
	private int nbCases = 30;
	private CaseNormale caseDebut = new CaseNormale(1);
	private CaseNormale caseFin = new CaseNormale(nbCases);
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
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
