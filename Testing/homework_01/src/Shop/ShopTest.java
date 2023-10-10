package Shop;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Shop testShop = new Shop();                                                     // создаем тестовый экземпляр класса Shop
        List<Product> newProductList = generateProductList();                       // созаем список товаров, который будет храниться в тестовом магазине
        testShop.setProducts(newProductList);                                           // передаем полученный список товаров в наш тестовый магазин

        Shop nullShop = new Shop();                                                 // тестовый экземаляр магазина, в котором список товаров пустой
        List<Product> nullProducts = null;
        nullShop.setProducts(nullProducts);

        // 1. Проверка правильности хранения товаров
        assertThat(newProductList.size()).isEqualTo(testShop.getProducts().size());     // проверяем, возвращает ли магазит такое же количество товаров, как в списке, который мы передали
        assertThat(newProductList).isEqualTo(testShop.getProducts());                   // проверяем, тот ли список, что мы передали, возаращает магазин.


        // 2. Проверка корректности работы метода getMostExpensiveProduct

        assertThat(generateProductList().get(3).getCost()).isEqualTo(testShop.getMostExpensiveProduct().getCost());
        assertThatThrownBy(()->nullShop.getMostExpensiveProduct()).isInstanceOf(NullPointerException.class);

        // 3. Проверка корректности работы метода корректности работы метода sortProductsByPrice
        Collections.sort(newProductList, Comparator.comparingInt(Product::getCost));
        assertThat(newProductList).isEqualTo(testShop.sortProductsByPrice());
        assertThatThrownBy(()->nullShop.sortProductsByPrice()).isInstanceOf(NullPointerException.class);
    }

    private static List<Product> generateProductList(){
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        product1.setTitle("Апельсины");
        product1.setCost(100);
        product2.setTitle("Мандарины");
        product2.setCost(182);
        product3.setTitle("Яблоки");
        product3.setCost(99);
        product4.setTitle("Ананасы");
        product4.setCost(356);
        product5.setTitle("Бананы");
        product5.setCost(10);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        return products;
    }



}