package homework.oopN1;

public class Product {
    String name;
    Double price;
    Double rating=0.0;
    int reviews;




    public Product(String name, Double price) {
        this.name=name;
        this.price=price;
       
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getRating() {
        return this.rating;
    }

    public String getName() {
        return this.name;
    }
    public void Review(int stars){
        this.reviews+=1;
        this.rating=(this.rating+stars)/reviews;
    }

    @Override
    public String toString() {
        return this.name +": "+this.price;
    }
}
