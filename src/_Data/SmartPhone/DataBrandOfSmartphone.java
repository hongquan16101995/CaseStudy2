package _Data.SmartPhone;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataBrandOfSmartphone {
    private final ArrayList<String> dataBrandOfSmartphone = new ArrayList<>();

    public DataBrandOfSmartphone() {
    }

    public ArrayList<String> createDataBrand(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-brand=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataBrandOfSmartphone.add(matcher.group(1));
            }
            if (dataBrandOfSmartphone.size() == 8) {
                break;
            }
        }
        return dataBrandOfSmartphone;
    }
}
