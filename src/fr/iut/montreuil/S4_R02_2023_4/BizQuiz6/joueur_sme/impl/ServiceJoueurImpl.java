package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.IserviceJoueur;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.PseudoDejaExistantException;

public class ServiceJoueurImpl implements IserviceJoueur {

    private ArrayList<JoueurDto> listeJoueursClassement = new ArrayList<JoueurDto>();
    private ArrayList<JoueurDto> listeJoueursActuels = new ArrayList<JoueurDto>();

    @Override
    public JoueurDto ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, Langue languePreferer,
                                   String centreDInteretListe) throws PseudoDejaExistantException {
        JoueurDto joueur = new JoueurDto(nom, pseudo, anneeDeNaissance, languePreferer, centreDInteretListe);
        for (JoueurDto joueurListe : this.listeJoueursActuels) {
            if (joueurListe.getPseudo().equals(joueur.getPseudo())) {
                throw new PseudoDejaExistantException();
            }
        }
        this.listeJoueursActuels.add(joueur);
        this.listeJoueursClassement.add(joueur);
        return joueur;
    }

    @Override
    public ArrayList<JoueurDto> listerJoueur() {

        return this.listeJoueursActuels;
    }

    @Override
    public boolean supprimerJoueur(String pseudo) {
        Iterator<JoueurDto> iterator = listeJoueursActuels.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPseudo().equals(pseudo)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<JoueurDto> getListeJoueur() {
        return listeJoueursActuels;
    }



}
