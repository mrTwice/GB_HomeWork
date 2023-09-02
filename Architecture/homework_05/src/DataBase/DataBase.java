package DataBase;

import Models.Product;
import Models.User;
import Products.Apple;
import Products.Google;
import Products.Samsung;

import java.util.*;

public class DataBase{
    private static List<Product> products;
    private static List<User> buyers;

    public DataBase (){
        this.products = new ArrayList<>();
        this.buyers= new ArrayList<>();

        buyers.add(new User("Андрей", "Федотов", 485412341, 12333123));
        buyers.add(new User("Денис", "Петров", 2345621, 147462045));
        buyers.add(new User("Валентин", "Серов", 1232412341, 12333123));
        buyers.add(new User("Олег", "Некрасов", 987412341, 12333123));
        products.add(new Apple("Products.Apple","iPhone", "Смартфон", 1000));
        products.add(new Samsung("Products.Samsung","GalaxyS23", "Смартфон", 1100));
        products.add(new Google("Products.Google","Pixel7", "Смартфон", 1200));
    }

    public static List<Product> getProducts(){
        return products;
    }
    public static List<User> getBuyers(){
        return buyers;
    }


}
