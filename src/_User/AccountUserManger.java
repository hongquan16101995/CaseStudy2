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

    public ArrayList<AccountUser> getAccountUserList(){
        return ioFile.readFileData("FileData/accountuser");
    }

    public boolean checkAccount(String account) {
        if (ioFile.readFileData("FileData/accountuser") == null) {
            return false;
        } else {
            ArrayList<AccountUser> accountUsers = getAccountUserList();
            for (AccountUser accountUser : accountUsers) {
                if (accountUser.getAccount().equals(account)) {
                    return true;
                }
            }
            return false;
        }
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
        ArrayList<AccountUser> list = getAccountUserList();
        Iterator<AccountUser> iterator = list.iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }
}
