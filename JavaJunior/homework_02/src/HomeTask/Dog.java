package HomeTask;

public class Dog extends  Animal{

    private String owner;

    public Dog(String name, int age, String owner) {
        super(name, age);
        this.owner = owner;
    }

    public void catchCat(){
        System.out.printf("%s пытается поймать кошку...", this.getName());
    }

    @Override
    public void makeSound() {
        System.out.println("Собака лает так: woof");
    }
}
