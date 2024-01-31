package ru.myhomework.homeworksecond.Serveces;

import org.springframework.stereotype.Service;
import ru.myhomework.homeworksecond.Domain.User;
import ru.myhomework.homeworksecond.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User getUserById(int id){
        return  userRepository.getUserById(id);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }
}
