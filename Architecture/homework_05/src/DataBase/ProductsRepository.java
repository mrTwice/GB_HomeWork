package DataBase;

import App.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    private static ProductsRepository productsRepository;
    private List<Product> products;

    private ProductsRepository(){
        productsRepository = getProductRepository();
    }

    public ProductsRepository getProductRepository(){
        if(productsRepository == null)
            productsRepository = new ProductsRepository();
        return productsRepository;
    }

    public void addNewProduct(Product product){
        if(products == null)
            products = new ArrayList<Product>();
        products.add(product);
    }
}
