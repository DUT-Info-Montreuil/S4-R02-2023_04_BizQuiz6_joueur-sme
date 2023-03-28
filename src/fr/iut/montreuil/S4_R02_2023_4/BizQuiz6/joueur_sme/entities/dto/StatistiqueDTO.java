package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto;

import java.util.ArrayList;

public class StatistiqueDTO {

    private Chrono chrono;
    private int nbBonnesReponses;

    public StatistiqueDTO(int nbBonnesReponses, Chrono chrono) {
        this.chrono = chrono;
        this.nbBonnesReponses = nbBonnesReponses;
    }
    public Chrono getChrono() {
        return this.chrono;
    }
    public int getNbBonnesReponses() {
        return this.nbBonnesReponses;
    }
}
