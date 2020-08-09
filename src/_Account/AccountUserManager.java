package _Account;

import _ReadWriteFile.IOFile;

import java.util.ArrayList;

public class AccountUserManager {
    private final ArrayList<AccountUser> accountUserList = new ArrayList<>();
    private final IOFile<AccountUser> ioFile = new IOFile<>();
    private final String PATHNAME_OF_ACCOUNTUSER = "FileData/accountuser";

    public AccountUserManager() {
    }

    public ArrayList<AccountUser> getAccountUserList() {
        return ioFile.readFileData(PATHNAME_OF_ACCOUNTUSER);
    }

    public void setListUser(String account, String password) {
        ArrayList<AccountUser> accountUsers;
        if (checkFile()) {
            accountUsers = accountUserList;
        } else {
            accountUsers = getAccountUserList();
        }
        accountUsers.add(new AccountUser(account, password));
        ioFile.writerFileData(accountUsers, PATHNAME_OF_ACCOUNTUSER);
    }

    public boolean checkFile() {
        ArrayList<AccountUser> accountUserList = getAccountUserList();
        return accountUserList == null;
    }
}
