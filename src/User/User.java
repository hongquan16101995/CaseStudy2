package User;

import java.io.*;

public class User implements Serializable{
    private String nameUser;
    private int ageUser;
    private long phonenumberUser;
    private String addressUser;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
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
        return "User{" + "nameUser='" + nameUser + '\'' + ", ageUser=" + ageUser +
                ", phonenumberUser=" + phonenumberUser + ", addressUser='" + addressUser + '\'' + "}";
    }
}
