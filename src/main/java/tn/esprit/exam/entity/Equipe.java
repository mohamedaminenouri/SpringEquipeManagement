package tn.esprit.exam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEquipe;
    String nomEquipe;
    LocalDate dateCreation;
    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    List<Rencontre> rencontreList;
    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    List<Joueur> joueurs;



}
