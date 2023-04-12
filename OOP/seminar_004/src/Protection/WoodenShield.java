package Protection;

import Protection.Shields;

public class WoodenShield extends Shields {

    private String name;

    public WoodenShield(int classOfProtections){
        super(classOfProtections);
        this.name = "Protection.WoodenShield";
    }
    @Override
    public int protection() {
        return 10;
    }
    @Override
    public String toString() {
        return "Protection.WoodenShield{" +
                " name = " + name +
                super.toString() +
                '}';
    }

}
