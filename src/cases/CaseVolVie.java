package cases;

import affichage.Affichage;
import jeu.Joueur;

public class CaseVolVie extends Case {
	
	public CaseVolVie(Affichage affichage) {
		super(affichage);
	}
	
	@Override
	public void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		super.affichage.afficherCaseVolVie("Le joueur est sur une Case VolVie.", joueurActuel.getNom(), joueurAdversaire.getNom());
		joueurActuel.ajouterVie(1);
		joueurAdversaire.ajouterVie(-1);
	}

}
