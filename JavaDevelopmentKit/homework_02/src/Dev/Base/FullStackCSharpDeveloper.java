package Dev.Base;

import Dev.Interfaces.FullStackDeveloper;

public class FullStackCSharpDeveloper implements FullStackDeveloper {
    @Override
    public void writeServersCode() {
        System.out.println("FullStackCSharpDeveloper writes servers code...");
    }

    @Override
    public void writeUICode() {
        System.out.println("FullStackCSharpDeveloper writes UIs code...");
    }
}
