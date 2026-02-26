package cases;

import jeu.Joueur;

public abstract class Case {
	
	private int numeroCase;
	
	public Case(int numeroCase)	{
		this.numeroCase = numeroCase;
	}
	
	protected abstract void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire);

}
