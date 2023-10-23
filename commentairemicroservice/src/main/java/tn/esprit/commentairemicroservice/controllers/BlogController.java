package tn.esprit.blogmicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.blogmicroservices.services.IBlogServicelmp;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogServicelmp iBlogService ;

    @PostMapping
    public ResponseEntity addBlog(@RequestBody Blog blog) {

        iBlogService.addBlog(blog);
        return new ResponseEntity<>("blog ajouté avec sucées!", HttpStatus.OK);
    }

    @PutMapping
    public Blog updateBlog(@RequestBody Blog blog ) {

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



}
