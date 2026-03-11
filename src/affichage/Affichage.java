package affichage;

import jeu.Couleur;

public class Affichage implements IAffichage {

	@Override
	public void afficherTour(int numeroJoueur) {
		System.out.println("\n----- C'est au joueur " + numeroJoueur + " de jouer -----");
	}

	@Override
	public void afficherJoueur(String nomJoueur, int vie, int position, Couleur couleurPion) {
		String message = nomJoueur + " (pion " + couleurPion + ") est sur la case n°" + position + " et possède " + vie + " point";
		if (vie > 1) {
			message += "s";
		}
		message += " de vie.";
		System.out.println(message);
	}

	@Override
	public void afficherCaseNormale(String message) {
		System.out.println(message);
		System.out.println("[ACTION] Cette case n'a aucun effet.");
	}

	@Override
	public void afficherCaseRouletteRusse(String message, int newPosition) {
		System.out.println(message);
		System.out.println("[ACTION] Le joueur a été déplacé sur la case n°" + newPosition + " !");
	}

	@Override
	public void afficherCaseVolVie(String message, String nomJoueur1, String nomJoueur2) {
		System.out.println(message);
		System.out.println("[ACTION] " + nomJoueur1 + " a volé un point de vie à " + nomJoueur2 + " !");
		
	}

	@Override
	public void afficherResultatDes(int resultatDes) {
		System.out.println("Résultat de dés : " + resultatDes);
	}

	@Override
	public void afficherDebutPartie(String nomJoueur1, String nomJoueur2) {
		System.out.println("======= NOUVEAU JEU =======");	
		System.out.println("Cette partie opposera " + nomJoueur1 + " à " + nomJoueur2 + ".");
		System.out.println("Les joueurs commencent sur la case n°1 et leur vie est initialisée à 5.");
		System.out.println("\nQue le meilleur gagne !");
	}

	@Override
	public void afficherFinPartie(String nomVainqueur, String nomPerdant, boolean vieNOK) {
		if (vieNOK) {
			System.out.println("\nLa vie de " + nomPerdant + " est tombé à 0...");
		} else {
			System.out.println("\n" + nomVainqueur + " a atteint l'arrivée !");
		}
		System.out.println("--> " + nomVainqueur + " a gagné la partie !");
	}

}
