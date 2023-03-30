package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6_sme.impl;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mockito;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
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
    
    @org.junit.jupiter.api.Test
    public void testFournirStatsJoueur() { 	
    	JoueurDto joueur = new JoueurDto("Dupont", "dupont", 1990, Langue.FRANCAIS, "Sport");
    	joueur.setNbPartiesJouer(1);
        Chrono chrono1 = Mockito.mock(Chrono.class);
        Mockito.when(chrono1.getDureeSec()).thenReturn(3600L); // 1 heure
        StatistiqueDTO stats1 = serviceJoueurMockOk.fournirStatsJoueur(joueur, 10, chrono1);
        assertNotNull(stats1,"on vérifie qu'un onbjet StatisqueDTO est bien retourner");
        assertEquals(10, stats1.getNbBonnesReponses(),"on vérifie que le nombre de points est correct");
        assertNotEquals(5,stats1.getNbBonnesReponses(),"Test qui vériefie que les points ne sont pas corrects");
        assertEquals(chrono1,stats1.getChrono(),"on vérifie que le bon chrono est retourner");
        assertEquals(3600, chrono1.getDureeSec(),"on vérifie que le temps est bon");
    }
    
    @Test
    public void testFournirStatsJoueurAvecServiceJoueurNull() {
        IserviceJoueur serviceJoueurMock = (IserviceJoueur) Mockito.mock(IserviceJoueur.class);
        ServiceJoueurImpl service = new ServiceJoueurImpl();
        JoueurDto joueur = new JoueurDto("Dupont", "dupont", 1990, Langue.FRANCAIS, "Sport");
        Chrono chrono = Mockito.mock(Chrono.class);
        Mockito.when(serviceJoueurMock.fournirStatsJoueur(joueur, 10, chrono)).thenReturn(null);
      
        StatistiqueDTO stats = service.fournirStatsJoueur(joueur, 10, chrono);
        assertNull(stats);
        assertEquals(0, joueur.getStats().size());
        assertEquals(0, joueur.getNbPartiesJouer());
        assertEquals(0.0, joueur.getMoyennePoints(), 0.001);
        Mockito.when(chrono.getDureeTxt()).thenReturn("0 h 0 min 0 s"); 
        assertEquals("0 h 0 min 0 s", chrono.getDureeTxt());
    }
    
    
    @Test
    public void testGestionScoreJoueur() {
        ServiceJoueurImpl service = new ServiceJoueurImpl();
        JoueurDto joueur = new JoueurDto("Dupont", "dupont", 1990, Langue.FRANCAIS, "Sport");
        Chrono chrono1 = Mockito.mock(Chrono.class);
        Mockito.when(chrono1.getDureeSec()).thenReturn(3600L); // 1 heure
        StatistiqueDTO stats1 = new StatistiqueDTO(10, chrono1);
        joueur.getStats().add(stats1);
        Chrono chrono2 = Mockito.mock(Chrono.class);
        Mockito.when(chrono2.getDureeSec()).thenReturn(1800L); // 30 minutes
        StatistiqueDTO stats2 = new StatistiqueDTO(8, chrono2);
        joueur.getStats().add(stats2);
        ArrayList<StatistiqueDTO> stats = service.gestionScoreJoueur(joueur);
        assertNotNull(stats);
        assertEquals(2, stats.size());
        assertEquals(stats1, stats.get(0));
        assertEquals(stats2, stats.get(1));
        
        assertEquals(stats1.getChrono().getDureeTxt(),stats.get((0)).getChrono().getDureeTxt());
        assertEquals(stats2.getChrono().getDureeTxt(),stats.get((1)).getChrono().getDureeTxt());
    }
    
 


}