package _User;

import _ReadWriteFile.IOFile;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountUserManger {
    private ArrayList<AccountUser> accountUserList;
    private IOFile<AccountUser> ioFile;

    public AccountUserManger() {
        accountUserList = new ArrayList<>();
        ioFile = new IOFile<>();
    }

    public ArrayList<AccountUser> getAccountUserList() {
        return ioFile.readFileData("FileData/accountuser");
    }

    public void setListUser(String account, String password) {
        ArrayList<AccountUser> accountUsers;
        if (getAccountUserList() != null) {
            accountUsers = getAccountUserList();
        } else {
            accountUsers = accountUserList;
        }
        accountUsers.add(new AccountUser(account, password));
        ioFile.writerFileData(accountUsers, "FileData/accountuser");
    }

    public boolean checkFile() {
        if (getAccountUserList() == null) {
            return true;
        }
        return false;
    }
}
