package tn.esprit.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Arbitre;
import tn.esprit.exam.entity.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {



}
