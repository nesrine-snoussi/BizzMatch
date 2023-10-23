package tn.esprit.blogmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Commentaire;

import java.util.List;

public interface CommentaireRepository  extends JpaRepository<Commentaire,Integer> {
    int countCommentaireByBlog(Blog blog);
}
