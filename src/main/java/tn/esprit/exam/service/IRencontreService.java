package tn.esprit.exam.service;

import tn.esprit.exam.entity.Arbitre;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Rencontre;

public interface IRencontreService {


  Rencontre ajoutRencontre( Rencontre re);
Arbitre ajouterArbitre(Arbitre a);
Equipe  ajouterEquipeEtJoueurs(Equipe e);
    Rencontre ajouterRencontreEtAffecterEquipe(Rencontre rencontre, long id1, long id2);

    void affecterArbitreARencontre(String nom , String prenom ,long IdR) throws Exception;
}
