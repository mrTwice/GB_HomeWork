package com.gb.homework.services;

import com.gb.homework.domain.Role;
import com.gb.homework.domain.User;
import com.gb.homework.repositories.RoleRepository;
import com.gb.homework.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
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

    public boolean saveUser(User user) {

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null)
            return false;

        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        if(userRepository.findAll().isEmpty()){
            user.setRoles(Collections.singleton(roleRepository.save(new Role(("ROLE_ADMIN")))));
        }else
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

    public User createUser(){
        return new User();
    }

    @PostConstruct
    public void addAdminUser(){
        if(!userRepository.existsByUsername("admin")){
            User adminUser = createUser();
            adminUser.setUsername("admin");
            adminUser.setEmail("admin@mail.ru");
            adminUser.setPassword("admin");
            saveUser(adminUser);
        }
    }
}
