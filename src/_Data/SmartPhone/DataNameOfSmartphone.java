package _Data.SmartPhone;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataNameOfSmartphone {
    private final ArrayList<String> dataNameOfSmartphone = new ArrayList<>();

    public DataNameOfSmartphone() {
    }

    public ArrayList<String> createDataName(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("<a href=\"/dtdd/(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataNameOfSmartphone.add(matcher.group(1).toUpperCase());
            }
            if (dataNameOfSmartphone.size() == 8) {
                break;
            }
        }
        return dataNameOfSmartphone;
    }
}
