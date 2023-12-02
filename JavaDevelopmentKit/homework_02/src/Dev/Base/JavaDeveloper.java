package Dev.Base;

import Dev.Interfaces.BackendDeveloper;

public class JavaDeveloper implements BackendDeveloper {
    @Override
    public void writeServersCode() {
        System.out.println("JavaDeveloper writes java servers code...");
    }
}
