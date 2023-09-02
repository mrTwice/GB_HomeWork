package Application;

import Models.Product;
import Models.User;

import java.util.List;

public class MarketPlace {
    private BuyersProvider buyersProvider;
    private ProductProvider productProvider;
    private User buyer;

    public MarketPlace(){
        this.productProvider = new ProductProvider();
        this.buyersProvider = new BuyersProvider();
    }

    public List<Product> showAllProductsInBasket(User buyer){
        return buyer.getBasket().getAddedProducts();
    }

    public boolean payTheProducts(User buyer, List<Product> productsInBasket){
        buyer = this.buyer;
        productsInBasket = showAllProductsInBasket(buyer);
        int cost = 0;
        for (Product p: productsInBasket) {
            cost += p.getPrice();
        }
        return true;
    }
}
