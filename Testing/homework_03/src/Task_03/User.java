package Task_03;

public class User {
    private String login;
    private String password;
    private boolean isAuth = false;
    private boolean isAdmin;


    public User(String login, String password, boolean isAdmin){
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public boolean auth(String login, String password){
        this.isAuth = (this.password == password && this.login == login);
        return isAuth;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

}
