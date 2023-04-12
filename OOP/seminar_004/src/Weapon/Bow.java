package Weapon;

public class Bow extends Throwing {
    private String name;

    public Bow(int distance) {
        super(distance);
        this.name = "Weapon.Weapon.Bow";
    }

    @Override
    public int damage() {
        return 10;
    }

    @Override
    public String toString() {
        return "Weapon.Weapon.Bow{" +
                " name = " + name +
                super.toString() +
                '}';
    }
}
