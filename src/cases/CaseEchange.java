package cases;

import java.security.SecureRandom;
import java.util.Random;

import affichage.Affichage;
import jeu.Joueur;

public class CaseEchange extends Case {
	
	private Random random;

	public CaseEchange(Affichage affichage) {
		super(affichage);
		
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void declencherAction(Joueur joueurActuel, Joueur joueurAdversaire) {
		int resultatRandom = random.nextInt(2);
		
		if (resultatRandom == 0) {
			int posJoueurActuel = joueurActuel.getPositionPlateau();
			joueurActuel.setPositionPlateau(joueurAdversaire.getPositionPlateau());
			joueurAdversaire.setPositionPlateau(posJoueurActuel);
		} else {
			int vieJoueurActuel = joueurActuel.getVie();
			joueurActuel.setVie(joueurAdversaire.getVie());
			joueurAdversaire.setVie(vieJoueurActuel);
		}
		
		super.affichage.afficherCaseEchange("Le joueur est sur une Case Echange.", resultatRandom);
		super.affichage.afficherJoueur(joueurActuel.getNom(), joueurActuel.getVie(), joueurActuel.getPositionPlateau(), joueurActuel.getCouleurPion());
		super.affichage.afficherJoueur(joueurAdversaire.getNom(), joueurAdversaire.getVie(), joueurAdversaire.getPositionPlateau(), joueurAdversaire.getCouleurPion());
	}
	
	

}
