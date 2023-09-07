package Application.Logic.Primitives;

import Application.Logic.Primitives.Users.Supplier;
import java.util.List;

public class Product {
    private static int id = 0;
    private String title;
    private int idCategory;
    private int idSubCategory;
    private int idType;
    private float cost;
    private List<Supplier> suppliers;

    public Product(String title, int idCategory, int idSubCategory, int idType, float cost) {
        this.id++;
        this.title = title;
        this.idCategory = idCategory;
        this.idSubCategory = idSubCategory;
        this.idType = idType;
        this.cost = cost;
    }

    public int getID(){
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public int getIdType() {
        return idType;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public List<Supplier> getProductSuppliers() {
        return suppliers;
    }

    public void addProductSupplier(Supplier supplier){
        suppliers.add(supplier);
    }
}
