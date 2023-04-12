package Protection;

import Protection.Protection;

public abstract class Shields implements Protection {
    private int classOfProtections;
    public Shields(int classOfProtections){
        this.classOfProtections = classOfProtections;
    }

    public int getClassOfProtections() {
        return classOfProtections;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "classOfProtections= " + classOfProtections +
                " protections = " + protection() +
                '}';
    }
}
