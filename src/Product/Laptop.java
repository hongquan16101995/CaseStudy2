package Product;

import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    public Laptop(String name, String brand, int price) {
        super(name, brand, price);
    }

    public Laptop(){}
}
