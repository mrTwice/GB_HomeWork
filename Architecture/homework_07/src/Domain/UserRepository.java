package Domain;

import Application.DataBaseInterfaces.IUserRepo;
import Application.Models.Primitives.User;

import java.util.List;

public class UserRepository implements IUserRepo {
    private static UserRepository userRepository;
    private List<User> users;

    private UserRepository(){
        userRepository = getUserRepository();
    }

    public static UserRepository getUserRepository(){
        if(userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }
    @Override
    public List<User> getAllUsers(){
        return null;
    }
    public User getUserByID(int id){
        return null;
    }
}
