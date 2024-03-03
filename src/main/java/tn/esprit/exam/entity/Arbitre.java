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
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArbitre;
    String nom;
    String prenom;
    String nationalite;
    Niveau niveau;
    @JsonIgnore
    @OneToMany(mappedBy = "arbitre")
    List<Rencontre > rencontreList;





}
