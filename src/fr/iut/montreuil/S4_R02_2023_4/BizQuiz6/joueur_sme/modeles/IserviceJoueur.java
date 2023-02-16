package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;

public interface IserviceJoueur {
	public JoueurDto ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, String languePreferer, String centreDInteretListe);
	public ArrayList<JoueurDto> listerJoueur();
	public boolean suprimerJoueur(String pseudo);
}
