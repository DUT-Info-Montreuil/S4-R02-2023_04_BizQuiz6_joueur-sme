package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.modeles.IserviceJoueur;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl.Mock.ServiceJoueurMockOk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceJoueurImplTest {

    ServiceJoueurMockOk serviceJoueurMockOk;
    private JoueurDto j1 = new JoueurDto("nono", "Nono78hls", 2003, "francais", "foot, manga");
    private ArrayList<JoueurDto> listeJoueur;


    @BeforeEach
    void setUp(TestInfo testInfo) throws Exception {
        serviceJoueurMockOk = new ServiceJoueurMockOk();
        this.listeJoueur = new ArrayList<>();
        this.listeJoueur.add(j1);
        System.out.println("test " + testInfo.getDisplayName());
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueur() {
        JoueurDto j2 = new JoueurDto("nono", "nono78hls", 2003, "francais", "foot, manga");
        JoueurDto j3 = new JoueurDto("Nono", "Nono78hls", 2003, "francais", "foot, manga");
        JoueurDto j4 = null;
        assertEquals(this.j1, serviceJoueurMockOk.ajouterJoueur("nono", "Nono78hls", 2003, "francais", "foot, manga"));
        assertNotEquals(this.j1, j2, "Voir si c'est différent lorsque le pseudo se ressemble");
        assertEquals(this.j1, j3, "voir si c'est le meme objet lorsque ce n'est pas le pseudo qui est different");
        assertEquals(j4, null);
    }

    @org.junit.jupiter.api.Test
    void listerJoueur() {

    }

    @org.junit.jupiter.api.Test
    void suprimerJoueur() {

        assertTrue(serviceJoueurMockOk.suprimerJoueur(this.j1.getPseudo()));
    }
}
