package _User;

import java.io.*;

public class User implements Serializable{
    private String nameUser;
    private long phonenumberUser;
    private String addressUser;

    public User(String nameUser, long phonenumberUser, String addressUser) {
        this.nameUser = nameUser;
        this.phonenumberUser = phonenumberUser;
        this.addressUser = addressUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public long getPhonenumberUser() {
        return phonenumberUser;
    }

    public void setPhonenumberUser(long phonenumberUser) {
        this.phonenumberUser = phonenumberUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    @Override
    public String toString() {
        return "User: " + "nameUser = '" + nameUser + '\'' + ", phonenumberUser = " + phonenumberUser + ", addressUser = '" + addressUser + '\'';
    }
}
