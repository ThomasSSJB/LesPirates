package cases;

import java.security.SecureRandom;
import java.util.Random;
import jeu.Joueur;

public class CaseRouletteRusse extends Case {
	
	private Random random;
	
	public CaseRouletteRusse() {
		super();
		
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		
	}
	
	@Override
	protected void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		System.out.println("Vous êtes sur une Case RouletteRusse."); // à remplacer avec Affichage
		joueurActuel.setPositionPlateau(random.nextInt(30));
	}

}
