package com.gb.homework.services;

import com.gb.homework.domain.Role;
import com.gb.homework.domain.User;
import com.gb.homework.repositories.ProjectRepository;
import com.gb.homework.repositories.RoleRepository;
import com.gb.homework.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User findUserById(Long userId){
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean createUser(User user) {

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null)
            return false;

        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        user.setRoles(Collections.singleton(roleRepository.findRoleByName("ROLE_USER")));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

}
