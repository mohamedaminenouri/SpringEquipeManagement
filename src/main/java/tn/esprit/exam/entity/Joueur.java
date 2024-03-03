package tn.esprit.exam.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idJoueur;
    String nom;
    String prenom;
    POSTE poste;

    @ManyToOne(cascade = CascadeType.ALL)
    Equipe equipe;





}
