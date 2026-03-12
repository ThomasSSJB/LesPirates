package cases;

import java.security.SecureRandom;
import java.util.Random;

import affichage.Affichage;
import jeu.Joueur;

public class CaseRouletteRusse extends Case {
	
	private Random random;
	
	public CaseRouletteRusse(Affichage affichage) {
		super(affichage);
		
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		int newPosition = random.nextInt(30);
		super.affichage.afficherCaseRouletteRusse("Le joueur est sur une Case RouletteRusse.", newPosition);
		joueurActuel.setPositionPlateau(newPosition);
	}

}
