package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Arbitre;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Rencontre;
import tn.esprit.exam.service.IRencontreService;
import tn.esprit.exam.service.RencontreServiceImpl;

@Tag(name = "Ce Web Service gère le CRUD pour une Rencontre")
@RestController
@AllArgsConstructor
@RequestMapping("/rencontre")
public class RencontreRestController {


     IRencontreService iRencontreService;
   /* IRencontreService rencontreService;

    // http://localhost:8089/exam/rencontre/retrieve-all-rencontres
    @Operation(description = "Ce web service permet de récupérer toutes les rencontres de la base de données")
    @GetMapping("/retrieve-all-rencontres")
    public List<Rencontre> getRencontres() {
        List<Rencontre> listRencontres = rencontreService.retrieveAllRencontres();
        return listRencontres;
    }
    // http://localhost:8089/exam/rencontre/retrieve-rencontre/8
    @GetMapping("/retrieve-rencontre/{rencontre-id}")
    public Rencontre retrieveRencontre(@PathVariable("rencontre-id") Long chId) {
        Rencontre rencontre = rencontreService.retrieveRencontre(chId);
        return rencontre;
    }

    // http://localhost:8089/exam/rencontre/add-rencontre
    @PostMapping("/add-rencontre")
    public Rencontre addRencontre(@RequestBody Rencontre c) {
        Rencontre rencontre = rencontreService.addRencontre(c);
        return rencontre;
    }

    // http://localhost:8089/exam/rencontre/remove-rencontre/{rencontre-id}
    @DeleteMapping("/remove-rencontre/{rencontre-id}")
    public void removeRencontre(@PathVariable("rencontre-id") Long chId) {
        rencontreService.removeRencontre(chId);
    }

    // http://localhost:8089/exam/rencontre/modify-rencontre
    @PutMapping("/modify-rencontre")
    public Rencontre modifyRencontre(@RequestBody Rencontre c) {
        Rencontre rencontre = rencontreService.modifyRencontre(c);
        return rencontre;
    }

*/

    // http://localhost:8089/exam/rencontre/add-rencontre
    @PostMapping("/add-rencontre")
    public Rencontre addRencontre(@RequestBody Rencontre c) {
        Rencontre rencontre = iRencontreService.ajoutRencontre(c);
        return rencontre;
    }

    @PostMapping("/add-arbitre")
    public Arbitre addArbitre(@RequestBody Arbitre a) {
        Arbitre arbitre = iRencontreService.ajouterArbitre(a);
        return arbitre;
    }


    @PostMapping("/add-equipe-Et-joueurs")
    public Equipe addArbitre(@RequestBody Equipe equipe) {
        Equipe equipeAdded = iRencontreService.ajouterEquipeEtJoueurs(equipe);
        return equipeAdded;
    }

     @PutMapping("/add-Rencontre-Et-Affecter-Equipe/{id-equi1}/{id-equi2}")
    public Rencontre addArbitre(@RequestBody Rencontre rencontre, @PathVariable("id-equi1") long id1, @PathVariable("id-equi2") long id2) {
        Rencontre rencontre1 = iRencontreService.ajouterRencontreEtAffecterEquipe(rencontre,id1,id2);
        return rencontre1;
    }



}
