package jeu;

public enum Couleur {
	BLEU("Bleu"), ROUGE("Rouge");
	
	private String nomCouleur;
	
	Couleur(String nomCouleur) {
		this.nomCouleur = nomCouleur;
	}
	
	public String getNomCouleur() {
		return nomCouleur;
	}
}
