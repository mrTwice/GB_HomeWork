package Application;

import Interfaces.IDataBase;
import Services.ProductsPerository;

public class ProductProvider {
    private IDataBase productRepository;

    public ProductProvider() {
        this.productRepository = ProductsPerository.getProductsPerository();
    }
}
