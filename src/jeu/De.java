package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class De {
	
	private Random random;
	
	public De() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int lancerDes() {
		int resultatDe1 = random.nextInt(5);
		int resultatDe2 = random.nextInt(5);		
		return resultatDe1 + resultatDe2;
	}

}
