package Task_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void authSuccessful(){
        User user = new User("user1", "1234567890", false);
        Assertions.assertTrue(user.auth("user1", "1234567890"));
    }

    @Test
    public void authUnSuccessful(){
        User user = new User("user1", "1234567890", false);
        Assertions.assertFalse(user.auth("user1", "12345678912"));
    }
}