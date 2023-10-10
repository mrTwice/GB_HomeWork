package Shop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        if(products.isEmpty())
            throw new NullPointerException("Cписок товаров пуст.");
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparingInt(Product::getCost)).collect(Collectors.toList());
        return sortedProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        Product ExpensiveProduct = products.stream().max(Comparator.comparing(Product::getCost)).orElseThrow(NullPointerException::new);
        return ExpensiveProduct;
    }

}