package jeu;

import cases.Case;

public class Jeu {
	
	private Joueur[] joueurs = new Joueur[2];
	private De[] des = new De[2];
	private Case[] cases = new Case[30];
	private int nbJoueurs = 2;
	private int nbDes = 2;
	private int nbCases = 30;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2) {
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;
		
		for (int i=0 ; i<nbDes ; i++) {
			des[i] = new De();
		}
		
	}
	
	public void deplacerJoueur(Joueur joueur) {
		
	}
	
	public void verifierFinPartie(Joueur joueur) {
		
	}

}
