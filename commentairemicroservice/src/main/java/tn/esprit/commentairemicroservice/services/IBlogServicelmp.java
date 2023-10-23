package tn.esprit.blogmicroservices.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.blogmicroservices.repositories.BlogRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class IBlogServicelmp implements IBlogService{
    BlogRepository blogRepository;

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
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
}
