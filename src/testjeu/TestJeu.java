package testjeu;

import affichage.Affichage;
import jeu.*;

public class TestJeu {
	
	public static void main(String[] args) {		
		Jeu jeu = new Jeu(new Affichage());		
		jeu.lancerJeu();
	}
}
