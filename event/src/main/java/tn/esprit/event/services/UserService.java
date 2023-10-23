package tn.esprit.event.services;

import tn.esprit.event.entities.User;

public interface UserService {
    User registerUser(User user);
    public void removeUser(Integer id);
    User updateEtudiant (User u);

    public User blockUser(Integer id);
    public User unblockUser(Integer id);
}
