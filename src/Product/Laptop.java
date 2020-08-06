package Product;

import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    public Laptop(int id, String name, String brand, int price) {
        super(id, name, brand, price);
    }

    public Laptop(){}
}
