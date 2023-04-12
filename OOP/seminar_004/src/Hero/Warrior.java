package Hero;

import Hero.Person;
import Protection.Protection;
import Weapon.Weapon;

import java.util.Random;

public class Warrior<T extends Weapon, P extends Protection> extends Person {
    protected T weapon;
    protected P shield;
    protected  static Random rand = new Random();

    public Warrior(String name, int hp, T weapon, P shield) {
        super(name, hp);
        this.weapon = weapon;
        this.shield = shield;
    }

    public int harm() {
        boolean isHit = rand.nextBoolean();
        int damage = 0;
        if (isHit) {
            damage = rand.nextInt(weapon.damage()+1);
        }
        return damage;
    }

    public int defense() {
        boolean isDef = rand.nextBoolean();
        int defense = 0;
        if (isDef) {
            defense = rand.nextInt(shield.protection()+1);
        }
        return defense;
    }




    @Override
    public String toString() {
        return "Hero.Warrior{" +
                " name = " + getName() +
                " hp = " + getHp() +
                " weapon = " + weapon +
                '}';
    }
}
