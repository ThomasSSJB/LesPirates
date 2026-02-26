package jeu;

import cases.CaseNormale;

public class Plateau {
	
	private int nbCases = 30;
	private CaseNormale caseDebut = new CaseNormale(1);
	private CaseNormale caseFin = new CaseNormale(30);
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
	}

	public int getNbCases() {
		return nbCases;
	}
}
