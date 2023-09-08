package Application.ViewInterfaces;

import Application.Logic.Primitives.Users.User;

import java.util.HashMap;

public interface View {
     HashMap<String, String> autorizationMenu();
     HashMap<String, String> loginMenu();
}
