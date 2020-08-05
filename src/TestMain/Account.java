package TestMain;

import java.util.ArrayList;

public class Account {

    private ArrayList<String> accountAdminList;
    private ArrayList<String> passwordAdminList;
    private ArrayList<String> accountUserList;
    private ArrayList<String> passwordUserList;

    public Account(){
        accountAdminList.add("Admin1");
        accountAdminList.add("Admin2");
        accountAdminList.add("Admin3");
        passwordAdminList.add("123456");
        passwordAdminList.add("123456");
        passwordAdminList.add("123456");
    }

    public ArrayList<String> getAccountAdminList() {
        return accountAdminList;
    }

    public ArrayList<String> getPasswordAdminList() {
        return passwordAdminList;
    }

    public ArrayList<String> getAccountUserList() {
        return accountUserList;
    }

    public void setAccountUserList(String accountUser) {
        this.accountUserList.add(accountUser);
    }

    public ArrayList<String> getPasswordUserList() {
        return passwordUserList;
    }

    public void setPasswordUserList(String passwordUser) {
        this.passwordUserList.add(passwordUser);
    }
}
