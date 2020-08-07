package _User;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountAdmin implements Serializable {
    private String adminAcc;
    private String adminPass;
    private ArrayList<AccountAdmin> accountAdminList = new ArrayList<>();

    public AccountAdmin(String adminAcc, String adminPass) {
        this.adminAcc = adminAcc;
        this.adminPass = adminPass;
    }

    public AccountAdmin() {
        accountAdminList.add(new AccountAdmin("ADMIN1", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN2", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN3", "123456"));
    }

    public String getAdminAcc() {
        return adminAcc;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdmin(String adminAcc, String adminPass) {
        accountAdminList.add(new AccountAdmin(adminAcc, adminPass));
    }

    public ArrayList<AccountAdmin> getAdminAccountList() {
        return accountAdminList;
    }

    @Override
    public String toString() {
        return "AdminAccount: " + "adminAcc = '" + adminAcc + '\'' + ", adminPass = '" + adminPass + '\'';
    }
}
