package _User;

import _ReadWriteFile.IOFile;

import java.util.ArrayList;
import java.util.Iterator;

public class UserManager {
    private ArrayList<User> userList;
    private IOFile<User> ioFile;

    public UserManager() {
        userList = new ArrayList<>();
        ioFile = new IOFile<>();
    }

    public ArrayList<User> getUserList() {
        return ioFile.readFileData("FileData/userinfo");
    }

    public void setListUser(String name, long phonenumber, String address) {
        ArrayList<User> users;
        if (getUserList() != null) {
            users = getUserList();
        } else {
            users = userList;
        }
        users.add(new User(name, phonenumber, address));
        ioFile.writerFileData(users, "FileData/userinfo");
    }

    public boolean checkFile() {
        if (getUserList() == null) {
            return true;
        }
        ArrayList<User> list = getUserList();
        Iterator<User> iterator = list.iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }
}
