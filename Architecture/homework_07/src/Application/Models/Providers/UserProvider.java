package Application.Models.Providers;

import Domain.UserRepository;

public class UserProvider {
    private UserRepository userRepository;
    public UserProvider(){
        this.userRepository = UserRepository.getUserRepository();
    }
}
