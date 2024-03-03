package tn.esprit.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {

Arbitre getArbitreByNomAndAndPrenom(String nom ,String prenom);

}
