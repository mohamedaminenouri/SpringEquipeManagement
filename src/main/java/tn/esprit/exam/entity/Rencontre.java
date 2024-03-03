package tn.esprit.exam.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRencontre;
    LocalDate dateMatch;
    int nbre_but;
    String nomStade;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToOne(cascade = CascadeType.ALL)
    Arbitre arbitre;

    @ManyToOne(cascade = CascadeType.ALL)
    Equipe equipe;
    @ManyToOne(cascade = CascadeType.ALL)
    Equipe equipe1;


}
