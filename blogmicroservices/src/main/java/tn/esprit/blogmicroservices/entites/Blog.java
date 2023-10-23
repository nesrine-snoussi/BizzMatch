package tn.esprit.blogmicroservices.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idBlog;
    private String auteur ;
    @Temporal(TemporalType.DATE)
    private Date datePublication;
    private String titre ;
    private String contenu ;
    @Lob
    private byte[] image;
    private boolean archive ;

    @ManyToOne
    Categorie categorie;

    @JsonIgnore
    @OneToMany(mappedBy = "blog")
    List<Commentaire> commentaireList;



}
