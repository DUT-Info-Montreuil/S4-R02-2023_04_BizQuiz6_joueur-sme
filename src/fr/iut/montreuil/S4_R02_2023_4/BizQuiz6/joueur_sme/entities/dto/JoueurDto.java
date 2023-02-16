package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto;

import java.util.Arrays;
import java.util.Objects;

public class JoueurDto {
	private String nom,pseudo;
	private int anneeDeNaissance;
	private String languePreferer;
	private String centreDInteretListe;
	private String[] centreDinteret;
	public JoueurDto(String nom, String pseudo, int anneeDeNaissance, String languePreferer, String centreDInteretListe) {
	
		this.nom = nom;
		this.pseudo = pseudo;
		this.anneeDeNaissance = anneeDeNaissance;
		this.languePreferer = languePreferer;
		this.centreDInteretListe = centreDInteretListe;
		this.centreDinteret = centreDInteretListe.trim().split(",");
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getAnneeDeNaissance() {
		return anneeDeNaissance;
	}
	public void setAnneeDeNaissance(int anneeDeNaissance) {
		this.anneeDeNaissance = anneeDeNaissance;
	}
	public String getLanguePreferer() {
		return languePreferer;
	}
	public void setLanguePreferer(String languePreferer) {
		this.languePreferer = languePreferer;
	}
	public String getCentreDInteretListe() {
		return centreDInteretListe;
	}
	public void setCentreDInteretListe(String centreDInteretListe) {
		this.centreDInteretListe = centreDInteretListe;
	}
	public String[] getCentreDinteret() {
		return centreDinteret;
	}
	public void setCentreDinteret(String[] centreDinteret) {
		this.centreDinteret = centreDinteret;
	}
	@Override
	public String toString() {
		return "JoueurDto [nom=" + nom + ", pseudo=" + pseudo + ", anneeDeNaissance=" + anneeDeNaissance
				+ ", languePreferer=" + languePreferer + ", centreDInteretListe=" + centreDInteretListe
				+ ", centreDinteret=" + Arrays.toString(centreDinteret) + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(pseudo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoueurDto other = (JoueurDto) obj;
		return Objects.equals(pseudo, other.pseudo);
	}

}
