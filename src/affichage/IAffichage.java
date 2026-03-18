package affichage;

import jeu.Couleur;

public interface IAffichage {
	
	void afficherTour(int numeroJoueur);
	void afficherJoueur(String nomJoueur, int vie, int position, Couleur couleurPion);
	void afficherCaseNormale(String message);
	void afficherCaseRouletteRusse(String message, int newPosition);
	void afficherCaseVolVie(String message, String nomJoueur1, String nomJoueur2);
	void afficherCaseEchange(String message, int resultatRandom);
	void afficherResultatDes(int resultatDes);
	void afficherDebutPartie(String nomJoueur1, String nomJoueur2);
	void afficherFinPartie(String nomVainqueur, String nomPerdant, boolean vieNOK);

}
