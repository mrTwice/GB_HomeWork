package Dev;

import Dev.Base.TeamProjectFactory;
import Dev.Interfaces.Developer;
import Dev.Interfaces.FrontendDeveloper;

import java.util.ArrayList;

public class Project {
    private static ArrayList<Developer> developers = new ArrayList<>();

    public static void main(String[] args) {
        TeamProjectFactory teamProjectFactory = new TeamProjectFactory();
        developers.add(teamProjectFactory.getFullstackDeveloper());
        developers.add(teamProjectFactory.getBackendDeveloper());
        developers.add(teamProjectFactory.getFrontendDeveloper());


        for (Developer developer: developers) {
            if (developer instanceof FrontendDeveloper)
                ((FrontendDeveloper) developer).writeUICode();
        }
    }
}
