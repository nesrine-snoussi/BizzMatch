package tn.esprit.blogmicroservices.services;

import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Categorie;


import java.util.List;

public interface ICategorieService {
    public Categorie addCategorie(Categorie categorie);
    public Categorie updateCategorie(Categorie categorie);
    public void removeCategorie(Integer IdCategorie);
    public List<String> getAllCategorieNoms();
    public List<Categorie> getAllCategorie();
    public Categorie getById(Integer IdCategorie);

}
