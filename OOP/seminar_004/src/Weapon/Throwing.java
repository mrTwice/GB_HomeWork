package Weapon;

public abstract class Throwing implements Weapon{
    private int distance;

    public Throwing (int distance){
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Weapon.Throwing{" +
                "distance = " + distance +
                "damage = " + damage() +
                '}';
    }
}
