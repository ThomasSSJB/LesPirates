package testJeu;

import affichage.Affichage;
import jeu.*;

public class TestJeu {
	
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("Jack Le Borgne", Couleur.ROUGE);
		Joueur joueur2 = new Joueur("Bill Jambe de Bois", Couleur.BLEU);
		
		Integer[] posCaseRouletteRusse = {3, 10, 15, 18, 24};
		Integer[] posCaseVolVie = {7, 12, 16, 20, 26};
		
		Affichage affichage = new Affichage();
		
		Plateau plateau = new Plateau(posCaseRouletteRusse, posCaseVolVie, affichage);
		Jeu jeu = new Jeu(joueur1, joueur2, plateau, affichage);
		
		jeu.lancerJeu();
	}
}
