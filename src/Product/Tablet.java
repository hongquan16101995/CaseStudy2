package Product;

public class Tablet extends Product{
    public Tablet(int id, String name, String brand, int price) {
        super(id, name, brand, price);
    }

    public Tablet(){}

    public void display(){
        System.out.print("Tablet:  ");
        System.out.printf("%-4s%-10d", "id:", getId());
        System.out.printf("%-6s%-45s", "name:", getName());
        System.out.printf("%-7s%-15s", "brand:", getBrand());
        System.out.printf("%-7s%-10d", "price:", getPrice());
        System.out.println();
    }
}
