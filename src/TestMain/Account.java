package TestMain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public static List<String> account() {
        List<String> account = new ArrayList<>();
        account.add("admin1");
        account.add("admin2");
        account.add("admin3");
        return account;
    }

    public static List<String> password() {
        List<String> password = new ArrayList<>();
        password.add("admin1");
        password.add("admin2");
        password.add("admin3");
        return password;
    }
}
