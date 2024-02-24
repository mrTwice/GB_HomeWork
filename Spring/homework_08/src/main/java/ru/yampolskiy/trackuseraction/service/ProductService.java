package ru.yampolskiy.trackuseraction.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.yampolskiy.trackuseraction.model.Product;
import ru.yampolskiy.trackuseraction.model.annotation.LogExecutionTime;
import ru.yampolskiy.trackuseraction.model.annotation.ProductActions;
import ru.yampolskiy.trackuseraction.model.annotation.ProductTracker;
import ru.yampolskiy.trackuseraction.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    @LogExecutionTime
    @ProductTracker(action = ProductActions.CREATE)
    public Product addNewProduct(Product newProduct){
        Optional<Product> optionalProduct = productRepository.findProductByTitle(newProduct.getTitle());
        if(optionalProduct.isPresent())
            throw new RuntimeException("Товар уже существует");
        if(newProduct.getId() != null)
            throw new RuntimeException("Попытка добавить товар с заранее установленным id");
        productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getProductList(){
        List<Product> allProducts =productRepository.findAll();
        if(allProducts.isEmpty())
            throw new RuntimeException("Список товаров пуст");
        return allProducts;
    }

    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
            throw new RuntimeException("Запрашиваемый товар отсутствует");
        Product product = optionalProduct.get();
        return product;
    }

    public void deleteProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
            throw new RuntimeException("Невозможно удалить. Товар не существует");
        Product product = optionalProduct.get();
        productRepository.delete(product);
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setTitle(updatedProduct.getTitle());
            existingProduct.setCost(updatedProduct.getCost());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setAmount(updatedProduct.getAmount());
            existingProduct.setReserved(updatedProduct.getReserved());
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Товар с таким индентификатором не найден:  " + id);
        }
    }
}
