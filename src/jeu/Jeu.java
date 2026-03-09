package jeu;

import affichage.Affichage;
import cases.CaseNormale;
import cases.CaseRouletteRusse;
import cases.CaseVolVie;

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
		des = new De();
	}

	public void lancerJeu() {
		int tour = 0;
		int resultatDes = 0;
		Joueur joueurActuel;
		Joueur joueurAdversaire;
		CaseRouletteRusse caseRouletteRusse = new CaseRouletteRusse(0); 
		CaseVolVie caseVolVie = new CaseVolVie(0);
		CaseNormale caseNormale = new CaseNormale(0);
		
		System.out.println("===== Nouveau Jeu =====");
		
		while (!verifierFinPartie(joueur1) && !verifierFinPartie(joueur2)) {			
			if (tour == 0) {
				joueurActuel = joueur1;
				joueurAdversaire = joueur2;
				tour = 1;
				System.out.println("\nC'est au joueur 1 de jouer !");
			} else {
				joueurActuel = joueur2;
				joueurAdversaire = joueur1;				
				tour = 0;
				System.out.println("\nC'est au joueur 2 de jouer !");
			}

			resultatDes = des.lancerDes();
			System.out.println("Résutat des dés : " + resultatDes);  // à remplacer par Affichage
			
			deplacerJoueur(joueurActuel, resultatDes);
			System.out.println("Position du joueur : " + joueurActuel.getPositionPlateau());
			
			if (plateau.verifierCaseRouletteRusse(joueurActuel.getPositionPlateau())) {
				caseRouletteRusse.declencherAction(joueurActuel, joueurAdversaire);
			} else if (plateau.verifierCaseVolVie(joueurActuel.getPositionPlateau())) {
				caseVolVie.declencherAction(joueurActuel, joueurAdversaire);
			} else {
				caseNormale.declencherAction(joueurActuel, joueurAdversaire);
			}
			
			System.out.println("Vie du joueur : " + joueurActuel.getVie());
			
		}
	}
	
	public void deplacerJoueur(Joueur joueur, int val) {
		if (joueur.getPositionPlateau()+val > plateau.getNbCases()) {
			val = joueur.getPositionPlateau()+val - plateau.getNbCases();
			joueur.setPositionPlateau(plateau.getNbCases() - val);
		} else {
			joueur.avancer(val);
		}
	}
	
	public boolean verifierFinPartie(Joueur joueur) {
		return (joueur.getPositionPlateau() == plateau.getCaseFin().getNumeroCase()) || (!joueur.estVivant());
	}

}
