package jeu;

public class Plateau {
	
	private int nbCases = 30;
	private Integer[] posCaseRouletteRusse;
	private Integer[] posCaseVolVie;
	
	public Plateau(Integer[] posCaseRouletteRusse, Integer[] posCaseVolVie) {
		this.posCaseRouletteRusse = posCaseRouletteRusse;
		this.posCaseVolVie = posCaseVolVie;
	}
}
