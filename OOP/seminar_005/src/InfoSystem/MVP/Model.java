package InfoSystem.MVP;

import InfoSystem.Personal.University;

public class Model {
    University ourUniversity;
    private String pathCommunityDB;

    private Model(String pathCommunityDB) {
        ourUniversity = new University();
        this.pathCommunityDB = pathCommunityDB;
    }

    public void loadDB() {
        
    }
}
