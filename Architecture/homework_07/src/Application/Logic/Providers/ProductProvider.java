package Application.Logic.Providers;

import Domain.ProductRepository;

public class ProductProvider {
    private ProductRepository productRepository;
    public ProductProvider(){
        this.productRepository = ProductRepository.getProductRepository();
    }

}
