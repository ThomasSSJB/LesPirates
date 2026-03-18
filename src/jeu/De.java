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
		return 2 + random.nextInt(5) + random.nextInt(5);
	}

}
