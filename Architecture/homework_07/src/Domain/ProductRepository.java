package Domain;

import Application.DataBaseInterfaces.IProductRepo;
import Application.Logic.Primitives.Product;
import java.util.List;

public class ProductRepository implements IProductRepo {
    private static ProductRepository productsRepository;
    private List<Product> products;

    private ProductRepository(){
        productsRepository = getProductRepository();
    }

    public static ProductRepository getProductRepository(){
        if(productsRepository == null)
            productsRepository = new ProductRepository();
        return productsRepository;
    }
@Override
    public List<Product> getAllProducts(){
        return null;
    }
    public Product getProductByID(int id){
        return null;
    }
}
