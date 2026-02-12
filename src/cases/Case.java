package cases;

import jeu.Joueur;

public abstract class Case {
	
	private int numeroCase;
	
	protected abstract void declencherAction(Joueur joueur);

}
