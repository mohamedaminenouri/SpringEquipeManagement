package tn.esprit.exam.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Arbitre;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Joueur;
import tn.esprit.exam.entity.Rencontre;
import tn.esprit.exam.repository.ArbitreRepository;
import tn.esprit.exam.repository.EquipeRepository;
import tn.esprit.exam.repository.JoueurRepository;
import tn.esprit.exam.repository.RencontreRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RencontreServiceImpl implements IRencontreService {
   RencontreRepository rencontreRepository;
   EquipeRepository equipeRepository;
   JoueurRepository joueurRepository;
   ArbitreRepository arbitreRepository;

    @Override
    public Rencontre ajoutRencontre(Rencontre rencontre) {
        return rencontreRepository.save(rencontre);
    }

    @Override
        public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Rencontre ajouterRencontreEtAffecterEquipe(Rencontre rencontre, long id1, long id2) {
        Equipe equipe1=equipeRepository.findById(id1).get();
        Equipe equipe2=equipeRepository.findById(id2).get();
       rencontre.setEquipe1(equipe1);
       rencontre.setEquipe(equipe2);
       rencontreRepository.save(rencontre);
        return rencontre;
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, long IdR) throws Exception {
                   Arbitre arbitre=arbitreRepository.getArbitreByNomAndAndPrenom(nom, prenom);
                   Rencontre rencontre=rencontreRepository.findById(IdR).get();
                   if (arbitre.getNiveau() !=rencontre.getNiveau()){
                       throw  new Exception("Execption declanche");
                   }
                   else
                   rencontre.setArbitre(arbitre);


    }
    @Scheduled(cron = "0 0 8 * * ?")

    void rencontreDeDateSys(){
        log.info("*********** les rencontres sont **********");
      List<Rencontre> rencontreList= rencontreRepository.findAll();
        for (Rencontre e:rencontreList
             ) {
            if (e.getDateMatch().equals(LocalDate.now())){
                log.info(" Rencontre entre "+e);
            }
        }
    }


}
