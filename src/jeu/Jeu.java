package jeu;

import affichage.Affichage;
import cases.CaseNormale;
import cases.CaseRouletteRusse;
import cases.CaseVolVie;

public class Jeu {
	
	private Affichage affichage;
	private De des = new De();
	private Joueur joueur1;
	private Joueur joueur2;
	private Plateau plateau;
	private int nbJoueurs = 2;
	private int nbDes = 2;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau, Affichage affichage) {	
		this.affichage = affichage;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.plateau = plateau;
	}

	public void lancerJeu() {
		affichage.afficherDebutPartie(joueur1.getNom(), joueur2.getNom());
		
		int tour = 0;
		int resultatDes = 0;
		Joueur joueurActuel;
		Joueur joueurAdversaire;
		CaseRouletteRusse caseRouletteRusse = new CaseRouletteRusse(0, affichage); 
		CaseVolVie caseVolVie = new CaseVolVie(0, affichage);
		CaseNormale caseNormale = new CaseNormale(0, affichage);
		
		while (!verifierFinPartie()) {			
			if (tour == 0) {
				joueurActuel = joueur1;
				joueurAdversaire = joueur2;
				tour = 1;
				affichage.afficherTour(1);
			} else {
				joueurActuel = joueur2;
				joueurAdversaire = joueur1;				
				tour = 0;
				affichage.afficherTour(2);
			}

			resultatDes = des.lancerDes();
			affichage.afficherResultatDes(resultatDes);
			
			deplacerJoueur(joueurActuel, resultatDes);
			affichage.afficherJoueur(joueurActuel.getNom(), joueurActuel.getVie(), joueurActuel.getPositionPlateau(), joueurActuel.getCouleurPion());
			
			if (plateau.verifierCaseRouletteRusse(joueurActuel.getPositionPlateau())) {
				caseRouletteRusse.declencherAction(joueurActuel, joueurAdversaire);
			} else if (plateau.verifierCaseVolVie(joueurActuel.getPositionPlateau())) {
				caseVolVie.declencherAction(joueurActuel, joueurAdversaire);
			} else {
				caseNormale.declencherAction(joueurActuel, joueurAdversaire);
			}			
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
	
	public boolean verifierFinPartie() {
		boolean finPartieOK = false;
		if (!joueur1.estVivant()) {
			affichage.afficherFinPartie(joueur1.getNom(), joueur2.getNom(), true);
			finPartieOK = true;
		} else if (!joueur2.estVivant()) {
			affichage.afficherFinPartie(joueur2.getNom(), joueur1.getNom(), true);
			finPartieOK = true;
		} else if (joueur1.getPositionPlateau() == plateau.getCaseFin().getNumeroCase()) {
			affichage.afficherFinPartie(joueur1.getNom(), joueur2.getNom(), false);
			finPartieOK = true;
		} else if (joueur2.getPositionPlateau() == plateau.getCaseFin().getNumeroCase()) {
			affichage.afficherFinPartie(joueur2.getNom(), joueur1.getNom(), false);
			finPartieOK = true;
		}
		return finPartieOK;
	}

}
