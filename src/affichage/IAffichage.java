package affichage;

import jeu.Couleur;

public interface IAffichage {
	
	void afficherJeu(String message);
	void afficherJoueur(String nomJoueur, int vie, Couleur couleurPion);
	void afficherCaseNormale(String message);
	void afficherCaseRouletteRusse(String message, int newPosition);
	void afficherCaseVolVie(String message, String nomJoueur1, String nomJoueur2);
	void afficherResultatDes(int resultatDes);
	void afficherDebutPartie(String nomJoueur1, String nomJoueur2);
	void afficherFinPartie(String message);

}
