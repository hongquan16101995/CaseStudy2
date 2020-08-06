package Product;

public class Product {
    private int id;
    private String name;
    private String brand;
    private int price;

    public Product(){
    }

    public Product(int id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void display(){
        System.out.printf("%-4s%-10d", "id:", id);
        System.out.printf("%-6s%-60s", "name:", name);
        System.out.printf("%-7s%-10s", "brand:", brand);
        System.out.printf("%-7s%-10d", "price:", price);
    }
}
