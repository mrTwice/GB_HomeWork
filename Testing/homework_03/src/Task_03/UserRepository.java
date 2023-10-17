package Task_03;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository userRepository;
    private List<User> autorizedUsers;

    private UserRepository(){
        autorizedUsers = new ArrayList<>();
    }

    public void addUser(User user){
        if (user.isAuth())
            autorizedUsers.add(user);
    }

    public static UserRepository getUserRepository(){
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public List<User> getAutorizedUsers() {
        return autorizedUsers;
    }

    public void logOutAllUsersExpectAdmin(){
        List<User> newAutorizedUsers = new ArrayList<>();
        for (User user: autorizedUsers) {
            if (!user.isAdmin()){
                user.setAuth(false);
            } else newAutorizedUsers.add(user);
        }
        this.autorizedUsers = newAutorizedUsers;
    }

}
