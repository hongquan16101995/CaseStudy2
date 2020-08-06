package Product;

public class SmartPhone extends Product{
    public SmartPhone(int id, String name, String brand, int price) {
        super(id, name, brand, price);
    }

    public SmartPhone(){}

    public void display(){
        System.out.print("Smartphone:  ");
        System.out.printf("%-4s%-10d", "id:", getId());
        System.out.printf("%-6s%-40s", "name:", getName());
        System.out.printf("%-7s%-18s", "brand:", getBrand());
        System.out.printf("%-7s%-10d", "price:", getPrice());
        System.out.println();
    }
}
