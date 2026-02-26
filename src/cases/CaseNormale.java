package cases;

import jeu.Joueur;

public class CaseNormale extends Case {
	
	public CaseNormale(int numeroCase) {
		super(numeroCase);
	}
	
	@Override
	protected void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		System.out.println("Vous êtes sur une Case Normale."); // à remplacer avec Affichage
	}

}
