package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.IserviceJoueur;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.PseudoDejaExistantException;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl.Mock.ServiceJoueurMockKo;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl.Mock.ServiceJoueurMockOk;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceJoueurImplTest {

    ServiceJoueurMockOk serviceJoueurMockOk;
    ServiceJoueurMockKo serviceJoueurMockKo;
    private JoueurDto j1 = new JoueurDto("nono", "Nono78hls", 2003, Langue.FRANCAIS, "foot, manga");
    private ArrayList<JoueurDto> listeJoueur;
    private IserviceJoueur j = new ServiceJoueurImpl();


    @BeforeEach
    void setUp(TestInfo testInfo) throws Exception {
        this.serviceJoueurMockOk = new ServiceJoueurMockOk();
        this.serviceJoueurMockKo = new ServiceJoueurMockKo();
        this.listeJoueur = new ArrayList<>();
        this.listeJoueur.add(j1);
        this.j = new ServiceJoueurImpl();
        System.out.println("test " + testInfo.getDisplayName());
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueur() {
        JoueurDto j2 = new JoueurDto("nono", "nono78hls", 2003, Langue.FRANCAIS, "foot, manga");
        JoueurDto j3 = new JoueurDto("Nono", "Nono78hls", 2003, Langue.FRANCAIS, "foot, manga");
        assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("nono", "Nono78hls", 2003, Langue.FRANCAIS, "foot, manga"));
        assertNotEquals(this.j1, j2, "Voir si c'est différent lorsque le pseudo se ressemble");
        assertEquals(this.j1, j3, "voir si c'est le meme objet lorsque ce n'est pas le pseudo qui est different");
        assertEquals(null, this.serviceJoueurMockKo.ajouterJoueur(null, null, 2000, null, null));
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMethode() throws PseudoDejaExistantException {
        JoueurDto j2 = new JoueurDto("nono", "nono78hls", 2003,Langue.FRANCAIS, "foot, manga");
        JoueurDto j3 = new JoueurDto("Nono", "Nono78hls", 2003, Langue.FRANCAIS, "foot, manga");
        assertEquals(this.j1, j.ajouterJoueur("nono", "Nono78hls", 2003, Langue.FRANCAIS, "foot, manga"));
        assertEquals(null, this.j.ajouterJoueur(null, null, 2000, null, "foot, manga"));
    }

    @org.junit.jupiter.api.Test
    void listerJoueur() {

    }

    @org.junit.jupiter.api.Test
    void supprimerJoueur() {
        assertTrue(this.serviceJoueurMockOk.supprimerJoueur(this.j1.getPseudo()));
        assertFalse(this.serviceJoueurMockKo.supprimerJoueur(null));
    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMethode() throws PseudoDejaExistantException {
        this.j.ajouterJoueur(j1.getNom(), j1.getPseudo(), j1.getAnneeDeNaissance(),j1.getLanguePreferer(), j1.getCentreDInteretListe());
        assertTrue(this.j.supprimerJoueur(this.j1.getPseudo()));
        assertFalse(this.j.supprimerJoueur(null));
    }
}