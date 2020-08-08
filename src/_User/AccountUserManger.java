package _User;

import _ReadWriteFile.IOFile;

import java.util.ArrayList;

public class AccountUserManger {
    private final ArrayList<AccountUser> accountUserList = new ArrayList<>();
    private final IOFile<AccountUser> ioFile = new IOFile<>();
    private final String PATHNAME_OF_ACCOUNTUSER = "FileData/accountuser";

    public AccountUserManger() {
    }

    public ArrayList<AccountUser> getAccountUserList() {
        return ioFile.readFileData(PATHNAME_OF_ACCOUNTUSER);
    }

    public void setListUser(String account, String password) {
        ArrayList<AccountUser> accountUsers;
        if (getAccountUserList() != null) {
            accountUsers = getAccountUserList();
        } else {
            accountUsers = accountUserList;
        }
        accountUsers.add(new AccountUser(account, password));
        ioFile.writerFileData(accountUsers, PATHNAME_OF_ACCOUNTUSER);
    }

    public boolean checkFile() {
        return getAccountUserList() == null;
    }
}
