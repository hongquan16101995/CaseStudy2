package _Data.Tablet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataNameOfTablet {
    private ArrayList<String> dataNameOfTablet;

    public DataNameOfTablet() {
        dataNameOfTablet = new ArrayList<>();
    }

    public ArrayList<String> createDataName(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("<a href=\"/may-tinh-bang/(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataNameOfTablet.add(matcher.group(1).toUpperCase());
            }
            if (dataNameOfTablet.size() == 8) {
                break;
            }
        }
        return dataNameOfTablet;
    }
}
