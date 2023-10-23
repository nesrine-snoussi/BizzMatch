package tn.esprit.blogmicroservices.services;


import java.util.List;

public interface ICategorieService {
    public Categorie addCategorie(Categorie categorie);
    public Categorie updateCategorie(Categorie categorie);
    public void removeCategorie(Integer IdCategorie);
    public List<Categorie> getAllCategorie();

    public Categorie getById(Integer IdCategorie);

}
