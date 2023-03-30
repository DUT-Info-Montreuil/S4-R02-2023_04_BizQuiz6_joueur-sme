package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl.Mock;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.IserviceJoueur;

import java.util.ArrayList;

public class ServiceJoueurMockOk implements IserviceJoueur {

    public ServiceJoueurMockOk() {
    }

    @Override
    public JoueurDto ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, Langue languePreferer, String centreDInteretListe) {
        JoueurDto j1 = new JoueurDto(nom, pseudo, anneeDeNaissance, languePreferer, centreDInteretListe);
        return j1;
    }

    @Override
    public ArrayList<JoueurDto> listerJoueur() {
        return null;
    }

    @Override
    public boolean supprimerJoueur(String pseudo) {
        return true;
    }

	@Override
	public StatistiqueDTO gestionScoreJoueur(JoueurDto joueurDto, int points, Chrono temps) {
		
		return new StatistiqueDTO(10, temps);
	}

	@Override
	public ArrayList<StatistiqueDTO> fournirStatJoueur(JoueurDto joueurDto) {
		// TODO Auto-generated method stub
		return null;
	}
}