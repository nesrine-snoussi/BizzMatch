package tn.esprit.chatmicroservice.repositories;

import tn.esprit.chatmicroservice.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}