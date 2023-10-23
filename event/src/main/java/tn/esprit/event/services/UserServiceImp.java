package tn.esprit.event.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.event.entities.User;
import tn.esprit.event.repositories.UserRepository;
//import tn.esprit.registermicroservice.entities.User;
//import tn.esprit.registermicroservice.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User registerUser(User user) {
        // Encode the password before saving it to the database
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setConfirmpassword(null); // Clear the confirmPassword field

        return userRepository.save(user);
    }

    @Override
    public void removeUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public User updateEtudiant(User u) {
        return userRepository.save(u);
    }

    @Override
    public User blockUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setBlocked(true);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User unblockUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setBlocked(false);
            userRepository.save(user);
        }
        return user;
    }
}
