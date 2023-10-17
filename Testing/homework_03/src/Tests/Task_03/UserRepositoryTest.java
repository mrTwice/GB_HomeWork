package Task_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    public void checkSuccesfullyAddUserInRepo(){
        User user = new User("user1", "1234567890", false);
        user.auth("user1", "1234567890");
        UserRepository.getUserRepository().addUser(user);
        Assertions.assertTrue(UserRepository.getUserRepository().getAutorizedUsers().contains(user));

    }

    @Test
    public void checkUnSuccesfullyAddUserInRepo(){
        User user2 = new User("user2", "1234567890", false);
        user2.auth("user2", "incorrectPass");
        UserRepository.getUserRepository().addUser(user2);
        assertFalse(UserRepository.getUserRepository().getAutorizedUsers().contains(user2));
    }

    @Test
    public void checkLogOutAllUsersExpectAdmin(){

        // Наполняем репозиторий пользователями
        User user = new User("user1", "1234567890", false);
        user.auth("user1", "1234567890");
        UserRepository.getUserRepository().addUser(user);
        User user2 = new User("user2", "1234567890", false);
        user2.auth("user2", "1234567890");
        UserRepository.getUserRepository().addUser(user2);
        User user3 = new User("user3", "1234567890", true);
        user3.auth("user3", "1234567890");
        UserRepository.getUserRepository().addUser(user3);
        User user4 = new User("user4", "1234567890", false);
        user4.auth("user4", "1234567890");
        UserRepository.getUserRepository().addUser(user3);

        // Деавторизуем пользователей, не являющихся администраторами
        UserRepository.getUserRepository().logOutAllUsersExpectAdmin();

        //проверяем состояние репозитория согласно условия
        assertFalse(UserRepository.getUserRepository().getAutorizedUsers().contains(user));
        assertFalse(UserRepository.getUserRepository().getAutorizedUsers().contains(user2));
        assertTrue(UserRepository.getUserRepository().getAutorizedUsers().contains(user3));
        assertFalse(UserRepository.getUserRepository().getAutorizedUsers().contains(user4));
    }

}