import Hero.Warrior;

public class Battle {
    private Warrior attacker;
    private Warrior definder;

    public Battle(Warrior attacker, Warrior definder) {
        this.attacker = attacker;
        this.definder = definder;
    }
    public Warrior run(){
        while (true){
            int attack = attacker.harm();
            definder.reduceHp(attack);
            System.out.printf("Hero.Warrior %s give harm %d\n Hero.Warrior %s %d HP\n", attacker.getName(), attack, definder.getName(), definder.getHp());
            if (!definder.isAlive()) {
                System.out.printf("Hero.Warrior %s is dead, %s winner", definder.getName(), attacker.getName());
                return attacker;
            }
            attack = definder.harm();
            attacker.reduceHp(attack);
            System.out.printf("Hero.Warrior %s return harm %d\n Hero.Warrior %s %d HP\n", definder.getName(), attack, attacker.getName(), attacker.getHp());
            if (!attacker.isAlive()) {
                System.out.printf("Hero.Warrior %s is dead, %s winner", attacker.getName(), definder.getName());
                return definder;
            }
        }
    }
}
