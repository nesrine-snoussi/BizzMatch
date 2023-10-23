package tn.esprit.blogmicroservices.services;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Categorie;
import tn.esprit.blogmicroservices.entites.Commentaire;
import tn.esprit.blogmicroservices.repositories.BlogRepository;
import tn.esprit.blogmicroservices.repositories.CommentaireRepository;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class ICommentaireServicelmp implements ICommentaireService {
    CommentaireRepository commentaireRepository;
BlogRepository blogRepository;
    @Override
    public Commentaire addCommentaire(Commentaire commentaire, Integer idBlog) {
        Blog blog = blogRepository.findById(idBlog).orElse(null);
        commentaire.setBlog(blog);
        Date currentDate = new Date();
        commentaire.setDatePublication(currentDate);
        commentaire.setAuteur("faten");
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void removeCommentaire(Integer IdCommentaire) {
        commentaireRepository.deleteById(IdCommentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire getById(Integer IdCommentaire) {
        return commentaireRepository.findById(IdCommentaire).orElse(null);
    }

}

