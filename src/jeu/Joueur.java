package jeu;

public class Joueur {
	
	private String nom;
	private int vie = 5;
	private int positionPlateau = 0;
	private Couleur couleurPion;
	
	public Joueur(String nom, Couleur couleurPion) {
		this.nom = nom;
		this.couleurPion = couleurPion;
	}
	
	public void avancer(int nbCases) {
		
	}
	
	public boolean estVivant() {
		return vie>0;
	}
	
	public void ajouterVie(int val) {
		vie += val;
	}

	public void setPositionPlateau(int newPositionPlateau) {
		positionPlateau = newPositionPlateau;
	}
	
}
