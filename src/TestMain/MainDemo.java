package TestMain;

import _Admin.RunByAdmin;
import _Data._OIDataByTGDD.ListProducts;
import _Login.Login;
import _Product.Laptop;
import _Product.Product;
import _ProductManager.ProductManager;
import java.util.ArrayList;

public class MainDemo {
    public static void main(String[] args) {
//        Login login = new Login();
//        login.loginSystem();
        RunByAdmin runByAdmin = new RunByAdmin();
        runByAdmin.menuProductOfAdmin();
//        RunByUser runByUser = new RunByUser();
//        runByUser.menuProductOfUser();

//        ArrayList<Laptop> arrayList = (new ListProducts()).getListLaptop();
//        for (Laptop laptop : arrayList) {
//            laptop.display();
//        }
//
//        ProductManager productManager = new ProductManager();
//        ArrayList<Product> arrayList1 = productManager.readFileData();
//        for (Product product : arrayList1) {
//            product.display();
//        }
    }
}
