package tn.esprit.blogmicroservices.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Commentaire;
import tn.esprit.blogmicroservices.repositories.BlogRepository;
import tn.esprit.blogmicroservices.repositories.CommentaireRepository;
import tn.esprit.blogmicroservices.services.IBlogServicelmp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Validated
@Slf4j
@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    IBlogServicelmp iBlogService ;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CommentaireRepository commentaireRepository;

    @PostMapping
    public ResponseEntity addBlog(@RequestPart("image") MultipartFile image) {
        try {
            Blog blog = new Blog();
            if (image != null && !image.isEmpty()) {
                blog.setImage(image.getBytes());
                Date currentDate = new Date();
                blog.setDatePublication(currentDate);
                blogRepository.save(blog);

                return new ResponseEntity<>("Blog ajouté avec succès!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Veuillez sélectionner une image.", HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            return new ResponseEntity<>("Erreur lors du traitement de l'image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PutMapping
    public Blog updateBlog(@RequestBody Blog blog) {

        return iBlogService.updateBlog(blog);
    }

    @GetMapping
    public List<Blog> findAllBlog() {
        return iBlogService.getAllBlog();
    }

    @GetMapping("/{idBlog}")
    public Blog findBlogById(@PathVariable int idBlog) {
        return iBlogService.getById(idBlog);
    }

    @DeleteMapping("/{idBlog}")
    public ResponseEntity removeBlog(@PathVariable int idBlog) {

        iBlogService.removeBlog(idBlog);
        return new ResponseEntity<>("Blog a été Supprimé!", HttpStatus.OK);

    }

    @PostMapping("/ajouter")
    public ResponseEntity ajouterBlog(@RequestParam("auteur") String auteur,
                            @RequestParam("titre") String titre,
                            @RequestParam("contenu") String contenu,
                            @RequestParam("image") MultipartFile image,
                            @RequestParam("idCategorie") int idCategorie) {
         iBlogService.ajouterBlog(auteur, titre, contenu, image, idCategorie);
        return new ResponseEntity<>("Blog ajouté avec succès!", HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = iBlogService.getAllBlogWithResizedImages();
        return blogs;
    }

    @GetMapping("/{idBlog}/commentaires")
    public List<Commentaire> getCommentairesByBlog(@PathVariable Integer idBlog) {
        Optional<Blog> blog = blogRepository.findById(idBlog);
        if (blog.isPresent()) {
            return blog.get().getCommentaireList();
        } else {
            // Gérer le cas où le blog n'existe pas
            return Collections.emptyList();
        }
    }
    @GetMapping("/{idBlog}/count")
    public int getNombreCommentairesParBlog(@PathVariable Integer idBlog) {
        // Récupérez l'objet Blog à partir de l'ID
        Blog blog = blogRepository.findById(idBlog).orElse(null);

        if (blog != null) {
            // Utilisez l'objet Blog pour compter les commentaires
            return commentaireRepository.countCommentaireByBlog(blog);
        } else {
            // Gérez le cas où le blog n'existe pas
            return 0; // Ou une autre valeur par défaut
        }
    }



}
