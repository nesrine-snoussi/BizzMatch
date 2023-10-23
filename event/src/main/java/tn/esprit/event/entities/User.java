package tn.esprit.event.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username;
    private String password;
    private String nom ;
    private String prenom;
    private String email;
    @Transient
    private String confirmpassword;
    private boolean blocked = false; // Champ pour indiquer si l'utilisateur est bloqué

    @ManyToOne
    private Evenement event;



}
