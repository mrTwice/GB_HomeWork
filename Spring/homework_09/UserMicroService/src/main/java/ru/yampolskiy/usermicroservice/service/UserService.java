package ru.yampolskiy.usermicroservice.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yampolskiy.usermicroservice.model.Role;
import ru.yampolskiy.usermicroservice.repository.UserRepository;
import ru.yampolskiy.usermicroservice.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        User newUser = getUserById(user.getId());
        if(newUser != null)
            throw new RuntimeException("Пользователь с таким id cуществует");
        newUser = userRepository.findUserByUsername(user.getUsername()).orElse(null);
        if(newUser != null)
            throw new RuntimeException("Пользователь с таким именем существует");
        user.setId(null);
        user.setRoles(Collections.singleton(Role.USER));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User updateUser = getUserById(id);
        if(updateUser == null)
            throw  new RuntimeException("Пользователь не существует");
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
