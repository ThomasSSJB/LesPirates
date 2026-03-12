package cases;

import affichage.Affichage;
import jeu.Joueur;

public class CaseNormale extends Case {
	
	public CaseNormale(Affichage affichage) {
		super(affichage);
	}
	
	@Override
	public void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		super.affichage.afficherCaseNormale("Le joueur est sur une Case Normale.");
	}

}
