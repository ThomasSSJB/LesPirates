package cases;

import affichage.Affichage;
import jeu.Joueur;

public abstract class Case {
	
	protected Affichage affichage;
	
	protected Case(Affichage affichage)	{
		this.affichage = affichage;
	}
	
	public abstract void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire);
}
