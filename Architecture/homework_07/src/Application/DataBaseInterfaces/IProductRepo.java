package Application.DataBaseInterfaces;

import Application.Logic.Primitives.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAllProducts();
    Product getProductByID(int id);
}
