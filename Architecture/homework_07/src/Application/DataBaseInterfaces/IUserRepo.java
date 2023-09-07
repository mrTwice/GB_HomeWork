package Application.DataBaseInterfaces;

import Application.Models.Primitives.User;

import java.util.List;

public interface IUserRepo {
    List<User> getAllUsers();
    User getUserByID(int id);
}
