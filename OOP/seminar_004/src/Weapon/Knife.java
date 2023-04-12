package Weapon;

public class Knife implements Weapon {
    @Override
    public int damage() {
        return 20;
    }

    @Override
    public String toString() {
        return "Weapon.Weapon.Knife{" +
                damage()+
                "}";
    }
}
