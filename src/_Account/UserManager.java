package _Account;

import _ReadWriteFile.IOFile;

import java.util.ArrayList;

public class UserManager {
    private final ArrayList<User> userList = new ArrayList<>();
    private final IOFile<User> ioFile = new IOFile<>();
    private final String PATHNAME_OF_USER = "FileData/userinfo";

    public UserManager() {
    }

    public ArrayList<User> getUserList() {
        return ioFile.readFileData(PATHNAME_OF_USER);
    }

    public void setListUser(String name, long phonenumber, String address) {
        ArrayList<User> users;
        if(checkFile()){
            users = userList;
        }else {
            users= getUserList();
        }
        users.add(new User(name, phonenumber, address));
        ioFile.writerFileData(users, PATHNAME_OF_USER);
    }

    public boolean checkFile() {
        ArrayList<User> userList = getUserList();
        return userList == null;
    }
}
