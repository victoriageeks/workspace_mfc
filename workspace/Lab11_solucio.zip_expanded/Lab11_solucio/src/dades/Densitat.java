package dades;

import java.io.Serializable;

public class Densitat implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private float densitat;
	
	public Densitat(String nomCiutat, float densitat) {
		this.nom=nomCiutat;
		this.densitat=densitat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getDensitat() {
		return densitat;
	}

	public void setDensitat(float densitat) {
		this.densitat = densitat;
	}

	@Override
	public String toString() {
		return "Densitat [nom=" + nom + ", densitat=" + densitat + "]";
	}
	
	
}
