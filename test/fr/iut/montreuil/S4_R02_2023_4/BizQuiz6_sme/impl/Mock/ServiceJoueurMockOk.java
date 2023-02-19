package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl.Mock;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.IserviceJoueur;

import java.util.ArrayList;

public class ServiceJoueurMockOk implements IserviceJoueur {

    public ServiceJoueurMockOk() {
    }

    @Override
    public JoueurDto ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, String languePreferer, String centreDInteretListe) {
        JoueurDto j1 = new JoueurDto(nom, pseudo, anneeDeNaissance, languePreferer, centreDInteretListe);
        return j1;
    }

    public JoueurDto ajouterJoueurMethodeFaite(JoueurDto joueurDto) {
        return ajouterJoueur(joueurDto.getNom(), joueurDto.getPseudo(), joueurDto.getAnneeDeNaissance(), joueurDto.getLanguePreferer(), joueurDto.getCentreDInteretListe());
    }

    @Override
    public ArrayList<JoueurDto> listerJoueur() {
        return listerJoueur();
    }

    @Override
    public boolean suprimerJoueur(String pseudo) {
        return suprimerJoueur(pseudo);
    }
}