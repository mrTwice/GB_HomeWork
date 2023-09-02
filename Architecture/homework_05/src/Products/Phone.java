package Products;

import Models.Product;

public class Phone extends Product {
    private String manufacturer;
    public Phone(String manufacturer, String name, String description, int price) {
        super(name, description, price);
        this.manufacturer = manufacturer;
    }
}
