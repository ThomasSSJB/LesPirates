package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class De {
	
	private int resultatDe;
	private Random random;
	
	public De() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void lancerDe() {
		resultatDe = random.nextInt(5);
	}
	
	public int getResultatDe() {
		return resultatDe;
	}

}
