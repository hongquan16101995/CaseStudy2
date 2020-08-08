package _Data.Laptop;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataBrandOfLaptop {
    private final ArrayList<String> dataBrandOfLaptop = new ArrayList<>();

    public DataBrandOfLaptop() {
    }

    public ArrayList<String> createDataBrand(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-brand=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataBrandOfLaptop.add(matcher.group(1));
            }
            if (dataBrandOfLaptop.size() == 8) {
                break;
            }
        }
        return dataBrandOfLaptop;
    }
}
