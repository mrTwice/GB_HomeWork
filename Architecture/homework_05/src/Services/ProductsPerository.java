package Services;

import DataBase.DataBase;
import Interfaces.IDataBase;
import Models.Product;

import java.util.List;

public class ProductsPerository implements IDataBase {
    private static ProductsPerository productsPerository;
    private List<Product> products;


    private ProductsPerository() {
        this.products = DataBase.getProducts();
    }

    public static ProductsPerository getProductsPerository(){
        if(productsPerository == null){
            productsPerository = new ProductsPerository();
        }
        return productsPerository;
    }
    @Override
    public List<Product> getAllProducts(){
        return products;
    }
    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }
    @Override
    public Product getProductById(int id){
        Product findingProduct = null;
        for (Product p: products) {
            if(p.getId() == id){
                findingProduct =  p;
            } else throw new RuntimeException("Can not find Product");
        }
        return findingProduct;
    }
}
