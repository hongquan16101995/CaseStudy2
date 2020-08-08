package _Data.Laptop;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataNameOfLaptop {
    private final ArrayList<String> dataNameOfLaptop = new ArrayList<>();

    public DataNameOfLaptop() {
    }

    public ArrayList<String> createDataName(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("<a href=\"/laptop/(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataNameOfLaptop.add(matcher.group(1).toUpperCase());
            }
            if (dataNameOfLaptop.size() == 8) {
                break;
            }
        }
        return dataNameOfLaptop;
    }
}
