package jeu;

import affichage.Affichage;

public class Jeu {
	
	private Affichage affichage;
	private De des = new De();
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur[] joueursJeu;
	private Plateau plateau;
	private boolean tourJoueur1 = true;
	
	public Jeu(Affichage affichage) {	
		this.affichage = affichage;
	}
	
	public void lancerJeu() {
		initialiserJeu();
		deroulerJeu();
	}
	
	private void initialiserJeu() {
		joueur1 = new Joueur("Jack Le Borgne", Couleur.ROUGE);
		joueur2 = new Joueur("Bill Jambe de Bois", Couleur.BLEU);
		joueursJeu = new Joueur[]{joueur2, joueur1};
		
		Integer[] posCaseRouletteRusse = {3, 10, 15, 18, 24};
		Integer[] posCaseVolVie = {7, 12, 16, 20, 26};
		Integer[] posCaseEchange = {9, 14, 17, 22, 28};

		plateau = new Plateau(posCaseRouletteRusse, posCaseVolVie, posCaseEchange, affichage);
	}

	private void deroulerJeu() {
		affichage.afficherDebutPartie(joueur1.getNom(), joueur2.getNom());
		
		int resultatDes = 0;
		int nbTour = 1;
		Joueur joueurActuel;
		Joueur joueurAdversaire;
		
		do {
			changerTour();
			joueurActuel = joueursJeu[0];
			joueurAdversaire = joueursJeu[1];
			affichage.afficherDebutTour(joueurActuel.getNom(), nbTour);

			resultatDes = des.lancerDeuxDes();
			affichage.afficherResultatDes(resultatDes);
			
			deplacerJoueur(joueurActuel, resultatDes);
			affichage.afficherJoueur(joueurActuel.getNom(), joueurActuel.getVie(), joueurActuel.getPositionPlateau(), joueurActuel.getCouleurPion());
			
			plateau.getCase(joueurActuel.getPositionPlateau()-1).declencherAction(joueurActuel, joueurAdversaire);
			
			nbTour++;
		} while (!verifierFinPartie());
	}
	
	private void changerTour() {
		if (tourJoueur1) {
			joueursJeu[0] = joueur1;
			joueursJeu[1] = joueur2;			
			tourJoueur1 = false;
		} else {
			joueursJeu[0] = joueur2;
			joueursJeu[1] = joueur1;
			tourJoueur1 = true;
		}
	}
	
	private void deplacerJoueur(Joueur joueur, int val) {
		if (joueur.getPositionPlateau()+val > plateau.getNbCases()) {
			val = joueur.getPositionPlateau()+val - plateau.getNbCases();
			joueur.setPositionPlateau(plateau.getNbCases() - val);
		} else {
			joueur.avancer(val);
		}
	}

	private boolean verifierFinPartie() {
		boolean finPartieOK = false;
		if (!joueur1.estVivant()) {
			affichage.afficherFinPartie(joueur2.getNom(), joueur1.getNom(), true);
			finPartieOK = true;
		} else if (!joueur2.estVivant()) {
			affichage.afficherFinPartie(joueur1.getNom(), joueur2.getNom(), true);
			finPartieOK = true;
		} else if (joueur1.getPositionPlateau() == plateau.getNbCases()) {
			affichage.afficherFinPartie(joueur1.getNom(), joueur2.getNom(), false);
			finPartieOK = true;
		} else if (joueur2.getPositionPlateau() == plateau.getNbCases()) {
			affichage.afficherFinPartie(joueur2.getNom(), joueur1.getNom(), false);
			finPartieOK = true;
		}
		return finPartieOK;
	}

}
