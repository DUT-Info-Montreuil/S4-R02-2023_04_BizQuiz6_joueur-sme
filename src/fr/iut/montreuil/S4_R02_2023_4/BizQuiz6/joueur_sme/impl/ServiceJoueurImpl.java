package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.impl;

import java.util.ArrayList;
import java.util.Iterator;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
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
        if(nom==null||pseudo==null||anneeDeNaissance<0||languePreferer==null||centreDInteretListe==null){
        	return null;
        }else {
        	this.listeJoueursActuels.add(joueur);
            this.listeJoueursClassement.add(joueur);
            return joueur;
        }
        
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

    public StatistiqueDTO fournirStatsJoueur(JoueurDto joueurDto, int points, Chrono temps){
        for(JoueurDto joueur : this.listeJoueursActuels){
            if(this.listeJoueursActuels.equals(joueur)){
                joueur.getStats().add(new StatistiqueDTO(points, temps));

                joueur.setNbPartiesJouer(joueur.getNbPartiesJouer()+1);

                long ChronoAuTotal = joueur.getMoyenneChrono().getDureeSec() + temps.getDureeSec();
                Chrono nouveauTempsMoyen = new Chrono();
                nouveauTempsMoyen.getDureeTxt(ChronoAuTotal);
                joueur.setMoyenneChrono(nouveauTempsMoyen);

                double moyennePoints = 0;
                for(int i =0; i<joueur.getStats().size(); i++)
                    moyennePoints += joueur.getStats().get(i).getNbBonnesReponses();
                moyennePoints = moyennePoints / joueur.getStats().size();
                joueur.setMoyennePoints(moyennePoints);

                return joueur.getStats().get(joueur.getStats().size());
            }
        }
        return null;
    }

    public ArrayList<StatistiqueDTO> gestionScoreJoueur(JoueurDto joueurDto){
        return joueurDto.getStats();
    }

    public ArrayList<JoueurDto> getListeJoueur() {
        return listeJoueursActuels;
    }



}
