package tn.esprit.blogmicroservices.services;

import tn.esprit.blogmicroservices.entites.Blog;

import java.util.List;

public interface IBlogService {
    public Blog addBlog(Blog blog);
    public Blog updateBlog(Blog blog);
    public void removeBlog(Integer IdBlog);
    public List<Blog> getAllBlog();

    public Blog getById(Integer IdBlog);
}
