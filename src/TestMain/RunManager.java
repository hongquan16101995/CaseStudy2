package TestMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunManager extends NewProductManager {
    private Scanner sc = new Scanner(System.in);
    public void Login(NewProductManager newProductManager) {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Nhập vào lựa chọn: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.println("Nhập account: ");
                String account = sc.nextLine();
                System.out.println("Nhập password: ");
                String passwword = sc.nextLine();
                if (check(account, passwword)) {
                    System.out.println("Đăng nhập thành công!");
                    Menu(newProductManager);
                } else
                    System.out.println("Đăng nhập thất bại!");
                break;
            case 2:
        }
    }

    public boolean check(String account, String pass) {
        List<String> accountList = Account.account();
        List<String> passwordList = Account.password();
        for (int i = 0; i < accountList.size(); i++) {
            if (account.equals(accountList.get(i)) && pass.equals(passwordList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void Menu(NewProductManager newProductManager) {
        boolean count = true;
        do {
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Sửa");
            System.out.println("4. Hiển thị");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nhập ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập hãng: ");
                    String brand = sc.nextLine();
                    System.out.println("Nhập giá: ");
                    int price = sc.nextInt();
                    newProductManager.addList(id, name, brand, price);
                    System.out.println("Thêm thành công!");
                    break;
                case 2:
                    if (newProductManager.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        newProductManager.deleteNewProduct();
                        System.out.println("Xóa thành công!");
                        break;
                    }
                case 3:
                    if (newProductManager.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else{
                        boolean check = true;
                        do {
                            System.out.println("Nhập ID: ");
                            int idedit = sc.nextInt();
                            if(newProductManager.newEditProduct(idedit)) {
                                edit(idedit, newProductManager);
                                check = false;
                            }else{
                                System.out.println("Nhập sai ID, mời nhập lại!");
                            }
                        }while (check);
                    }
                    break;
                case 4:
                    if (newProductManager.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        ArrayList<NewProduct> list = newProductManager.display();
                        for (NewProduct newP : list) {
                            System.out.println(newP);
                        }
                    }
                    break;
            }
        } while (count);
    }

    public void edit(int id, NewProductManager newProductManager) {
        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa hãng");
        System.out.println("3. Sửa giá");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.println("Nhập tên mơi: ");
                String name = sc.nextLine();
                newProductManager.editName(id, name);
                System.out.println("Sửa thành công!");
                break;
            case 2:
                sc.nextLine();
                System.out.println("Nhập hãng mơi: ");
                String brand = sc.nextLine();
                newProductManager.editBrand(id, brand);
                System.out.println("Sửa thành công!");
                break;
            case 3:
                sc.nextLine();
                System.out.println("Nhập giá mơi: ");
                int price = sc.nextInt();
                newProductManager.editPrice(id, price);
                System.out.println("Sửa thành công!");
                break;
        }
    }
}
