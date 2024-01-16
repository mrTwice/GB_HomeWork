package HomeTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object[] animals = new Object [10];
        getAnimals(animals);

        for(Object object: animals){
            System.out.println("#############################");
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields){
                System.out.println("Поле: " + field.getName());
            }
            Constructor[] constructors = object.getClass().getDeclaredConstructors();
            for (Constructor constructor : constructors){
                System.out.println("Конструктор: " + constructor.getName());
            }
            Method[] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods){
                System.out.println("Метод: " + method.getName());
            }
            if(Arrays.stream(methods).anyMatch(method -> method.getName().equals("makeSound"))){
                Method soundMethod = object.getClass().getMethod("makeSound");
                soundMethod.invoke(object);
            }
            System.out.println("#############################");
        }

    }

    private static void getAnimals(Object[] animals) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < animals.length; i++){
            boolean rnd = random.nextBoolean();
            if (rnd) {
                Class<?> cat = Class.forName("HomeTask.Cat");
                Constructor<?>[] constructor = cat.getConstructors();
                Object someCat = constructor[0].newInstance("Cat"+i, random.nextInt(1, 13), "owner"+i);
                animals[i] = someCat;
            }

            else {
                Class<?> dog = Class.forName("HomeTask.Dog");
                Constructor<?>[] constructor = dog.getConstructors();
                Object someDog = constructor[0].newInstance("Dog"+i, random.nextInt(1, 13), "owner"+i);
                animals[i] = someDog;
            }

        }
    }
}
