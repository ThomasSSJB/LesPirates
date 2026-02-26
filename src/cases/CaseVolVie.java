package cases;

import jeu.Joueur;

public class CaseVolVie extends Case {
	
	public CaseVolVie(int numeroCase) {
		super(numeroCase);
	}
	
	@Override
	protected void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		System.out.println("Vous êtes sur une Case VolVie."); // à remplacer avec Affichage
		joueurActuel.ajouterVie(1);
		joueurAdversaire.ajouterVie(-1);
	}

}
