package HomeTask;

public class Cat extends Animal{

    private String owner;

    public Cat(String name, int age, String owner) {
        super(name, age);
        this.owner = owner;
    }

    public void catchMouse(){
        System.out.printf("%s пытается поймать мышь...", this.getName());
    }

    @Override
    public void makeSound() {
        System.out.println("Так мяукает кот: meow");
    }
}
