package cases;

import affichage.Affichage;
import jeu.Joueur;

public abstract class Case {
	
	private int numeroCase;
	protected Affichage affichage;
	
	protected Case(int numeroCase, Affichage affichage)	{
		this.numeroCase = numeroCase;
		this.affichage = affichage;
	}
	
	protected abstract void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire);
	
	public int getNumeroCase() {
		return numeroCase;
	}
}
