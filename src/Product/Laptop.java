package Product;

import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    public Laptop(int id, String name, String brand, int price) {
        super(id, name, brand, price);
    }

    public Laptop(){}

    public void display(){
        System.out.print("Laptop:  ");
        System.out.printf("%-4s%-10d", "id:", getId());
        System.out.printf("%-6s%-55s", "name:", getName());
        System.out.printf("%-7s%-10s", "brand:", getBrand());
        System.out.printf("%-7s%-10d", "price:", getPrice());
        System.out.println();
    }
}
