package Interfaces;

import Models.User;

import java.util.List;

public interface IBuyer {
    List<User> getBuyersList();
    User getBuyerById(int id);
}
