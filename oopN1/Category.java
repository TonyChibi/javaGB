package homework.oopN1;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
    String name;
    ArrayList <Product> prods;
    public Category(String name) {
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Product> getProds() {
        return this.prods;
    }
    public void add(Product prod){
        this.prods.add(prod);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
