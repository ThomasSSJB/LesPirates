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
	
	public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau, Affichage affichage) {	
		this.affichage = affichage;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.joueursJeu = new Joueur[]{joueur2, joueur1};
		this.plateau = plateau;
	}

	public void lancerJeu() {
		affichage.afficherDebutPartie(joueur1.getNom(), joueur2.getNom());
		
		int resultatDes = 0;
		Joueur joueurActuel;
		Joueur joueurAdversaire;
		
		while (!verifierFinPartie()) {
			changerTour();			
			joueurActuel = joueursJeu[0];
			joueurAdversaire = joueursJeu[1];

			resultatDes = des.lancerDes();
			affichage.afficherResultatDes(resultatDes);
			
			deplacerJoueur(joueurActuel, resultatDes);
			affichage.afficherJoueur(joueurActuel.getNom(), joueurActuel.getVie(), joueurActuel.getPositionPlateau(), joueurActuel.getCouleurPion());
			
			plateau.getCase(joueurActuel.getPositionPlateau()-1).declencherAction(joueurActuel, joueurAdversaire);
		}
	}
	
	public void changerTour() {
		if (tourJoueur1) {
			joueursJeu[0] = joueur1;
			joueursJeu[1] = joueur2;			
			tourJoueur1 = false;
			affichage.afficherTour(1);
		} else {
			joueursJeu[0] = joueur2;
			joueursJeu[1] = joueur1;
			tourJoueur1 = true;		
			affichage.afficherTour(2);	
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
