package App.MVP;

import App.Models.Product;

import java.util.List;

public interface Model {
    List<Product> getAllProducts();
    Product getProductByID();
    void addProductToBasket();
}
