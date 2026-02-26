package jeu;

import affichage.Affichage;

public class Jeu {
	
	private Affichage affichage;
	private Joueur joueur1;
	private Joueur joueur2;
	private De des;
	private Plateau plateau;
	private int nbJoueurs = 2;
	private int nbDes = 2;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau) {	
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.plateau = plateau;		
	}

	public void lancerJeu() {
		int tour = 0;
		int resultatDes = 0;
		Joueur joueurActuel;
		Joueur joueurAdversaire;
		
		while (!verifierFinPartie(joueur1) || !verifierFinPartie(joueur2)) {
			resultatDes = des.lancerDes();
			// à ajouter : affichage du résultat des dés
			
			if (tour == 0) {
				joueurActuel = joueur1;
				joueurAdversaire = joueur2;
				tour = 1;
			} else {
				joueurActuel = joueur1;
				joueurAdversaire = joueur2;				
				tour = 0;
			}
			
			deplacerJoueur(joueurActuel, resultatDes);
			
			
		}
	}
	
	public void deplacerJoueur(Joueur joueur, int val) {
		if (joueur.getPositionPlateau()+val > plateau.getNbCases()) {
			val = joueur.getPositionPlateau()+val;
			joueur.avancer(-val);
		}
		joueur.avancer(val);
	}
	
	public boolean verifierFinPartie(Joueur joueur) {
		return false;
	}

}
