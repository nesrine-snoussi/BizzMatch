package tn.esprit.blogmicroservices.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.blogmicroservices.entites.Blog;
import tn.esprit.blogmicroservices.entites.Categorie;
import tn.esprit.blogmicroservices.repositories.BlogRepository;
import tn.esprit.blogmicroservices.repositories.CategorieRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class IBlogServicelmp implements IBlogService{
    BlogRepository blogRepository;
    CategorieRepository categorieRepository;

   @Override
   public Blog addBlog(Blog blog) {
     //  return blogRepository.save(blog);
       return null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void removeBlog(Integer IdBlog) {
        blogRepository.deleteById(IdBlog);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getById(Integer IdBlog) {
        return blogRepository.findById(IdBlog).orElse(null);
    }
    public Blog ajouterBlog(String auteur, String titre, String contenu, MultipartFile image, int idCategorie) {
        Blog blog = new Blog();
        blog.setAuteur(auteur);
        Date currentDate = new Date();
        blog.setDatePublication(currentDate);
        blog.setTitre(titre);
        blog.setContenu(contenu);
        blog.setArchive(false);

        try {
            blog.setImage(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();

        }
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        blog.setCategorie(categorie);
        return blogRepository.save(blog);
    }



    public List<Blog> getAllBlogWithResizedImages() {
        List<Blog> blogs = blogRepository.findAll();

        for (Blog blog : blogs) {
            // Redimensionnez l'image de chaque blog
            blog.setImage(resizeImage(blog.getImage(), 300, 200));
        }

        return blogs;
    }

    private byte[] resizeImage(byte[] imageData, int newWidth, int newHeight) {
        try {
            // Créez une BufferedImage à partir des données binaires de l'image
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData);
            BufferedImage originalImage = ImageIO.read(byteArrayInputStream);

            // Redimensionnez l'image à la taille souhaitée
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            // Convertissez l'image redimensionnée en tableau de bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "jpg", byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Gérez les erreurs comme vous le souhaitez
        }
    }



}
