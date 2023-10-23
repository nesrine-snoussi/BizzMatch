package tn.esprit.blogmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.blogmicroservices.entites.Blog;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
