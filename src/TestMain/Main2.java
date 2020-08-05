package TestMain;


public class Main2 {
    public static void main(String[] args) {
        NewProductManager newProductManager = new NewProductManager();
        RunManager runManager = new RunManager();

//        runManager.Login(newProductManager);
        runManager.Menu(newProductManager);
    }
}
