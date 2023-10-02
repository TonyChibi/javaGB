package homework.oopN1;

import java.util.ArrayList;



public class Basket {
    ArrayList<Product> prods= new ArrayList<>();



     public ArrayList<Product> getProds() {
         return this.prods;
     }
    public void add(Product prod){
        this.prods.add(prod);
    }
}
