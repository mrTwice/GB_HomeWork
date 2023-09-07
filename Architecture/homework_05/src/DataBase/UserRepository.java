package DataBase;

import App.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository userRepository;
    private List<User> users;

    private UserRepository(){
        this.userRepository = getUserReposytory();
    }
    public UserRepository getUserReposytory(){
        if(userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    public boolean addNewUser(User user){
        if(users == null)
            users = new ArrayList<User>();
        if(users.contains((User) user)){
            throw new RuntimeException("Такой пользователь уже существует");
        }
        users.add(user);
        return true;
    }

 }
