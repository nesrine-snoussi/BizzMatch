package tn.esprit.blogmicroservices.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esprit.blogmicroservices.entites.Commentaire;
import tn.esprit.blogmicroservices.services.ICommentaireService;


import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/commentaire")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentaireController {
    @Autowired
    ICommentaireService iCommentaireService ;

    @PostMapping("/{idBlog}")
    public ResponseEntity addCommentaire(@RequestBody Commentaire commentaire, @PathVariable int idBlog) {

        iCommentaireService.addCommentaire(commentaire,idBlog);
        return new ResponseEntity<>("Commentaire ajouté avec sucées!", HttpStatus.OK);
    }

    @PutMapping
    public Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {

        return iCommentaireService.updateCommentaire(commentaire);
    }

    @GetMapping
    public List<Commentaire> findAllCommentaire() {
        return iCommentaireService.getAllCommentaire();
    }


    @GetMapping("/{idCommentaire}")
    public Commentaire findCommentaireById(@PathVariable int idCommentaire) {
        return iCommentaireService.getById(idCommentaire);
    }

    @DeleteMapping("/{idCommentaire}")
    public ResponseEntity removeCommentaire(@PathVariable int idCommentaire) {

        iCommentaireService.removeCommentaire(idCommentaire);
        return new ResponseEntity<>("Commentaire a été Supprimé!", HttpStatus.OK);

    }

}
