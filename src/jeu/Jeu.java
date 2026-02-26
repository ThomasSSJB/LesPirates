package jeu;

import cases.Case;
import affichage.Affichage;

public class Jeu {
	
	private Affichage affichage;
	private Joueur joueur1 = new Joueur[2];
	private De[] des = new De[2];
	private Plateau plateau;
	private int nbJoueurs = 2;
	private int nbDes = 2;
	private int nbCases = 30;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau) {	
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;
		this.plateau = plateau;
		
		for (int i=0 ; i<nbDes ; i++) {
			des[i] = new De();
		}
		
	}
	
	public void deplacerJoueur(Joueur joueur) {
		
	}
	
	public void verifierFinPartie(Joueur joueur) {
		
	}

}
