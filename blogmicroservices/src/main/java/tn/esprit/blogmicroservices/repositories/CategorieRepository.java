package tn.esprit.blogmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.blogmicroservices.entites.Categorie;
public interface CategorieRepository  extends JpaRepository<Categorie,Integer> {
    Categorie findByNom(String nom);


}
