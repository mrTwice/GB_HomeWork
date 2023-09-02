package Services;

import Interfaces.IBasket;
import Models.Product;

import java.util.ArrayList;
import java.util.List;

public class BasketRepository implements IBasket {
    private List<Product> addedProducts;
    public BasketRepository() {
        if ((addedProducts == null))
            this.addedProducts = new ArrayList<>();
    }

    @Override
    public void addProductToBasket(Product product) {
        addedProducts.add(product);
    }
    public List<Product> getAddedProducts(){
        return addedProducts;
    }
}
