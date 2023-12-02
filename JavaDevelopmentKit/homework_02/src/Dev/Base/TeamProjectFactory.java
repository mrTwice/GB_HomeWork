package Dev.Base;

import Dev.Interfaces.BackendDeveloper;
import Dev.Interfaces.FrontendDeveloper;
import Dev.Interfaces.FullStackDeveloper;
import Dev.Interfaces.ProjectFactory;

public class TeamProjectFactory implements ProjectFactory {
    @Override
    public FullStackDeveloper getFullstackDeveloper() {
        return new FullStackCSharpDeveloper();
    }

    @Override
    public BackendDeveloper getBackendDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public FrontendDeveloper getFrontendDeveloper() {
        return new PythonDeveloper();
    }
}
