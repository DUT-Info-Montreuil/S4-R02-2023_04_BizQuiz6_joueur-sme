package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles;

import java.util.ArrayList;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;


public interface IserviceJoueur {
	public JoueurDto ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, Langue langue, String centreDInteretListe) throws PseudoDejaExistantException;
	public ArrayList<JoueurDto> listerJoueur();

	public boolean supprimerJoueur(String pseudo);

	public StatistiqueDTO gestionScoreJoueur(JoueurDto joueurDto, int points, Chrono temps);

	public ArrayList<StatistiqueDTO> fournirStatJoueur(JoueurDto joueurDto);
}