package tn.esprit.blogmicroservices.services;

import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Commentaire;

import java.util.List;

public interface ICommentaireService {
    public Commentaire addCommentaire(Commentaire commentaire, Integer idBlog);
    public Commentaire updateCommentaire(Commentaire commentaire);
    public void removeCommentaire(Integer IdCommentaire);
    public List<Commentaire> getAllCommentaire();

    public Commentaire getById(Integer IdCommentaire);


}
