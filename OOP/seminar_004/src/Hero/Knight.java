package Hero;

import Protection.Protection;
import Weapon.Knife;

public class Knight extends Warrior<Knife, Protection> {
    public Knight(String name, int hp, Knife weapon, Protection shield) {
        super(name, hp, weapon, shield);
    }

    @Override
    public String toString() {
        return "Hero.Knight{" +
                super.toString()+
                '}';
    }
}
