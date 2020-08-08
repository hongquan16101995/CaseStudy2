package _Data.Laptop;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataIdOfLaptop {
    private final ArrayList<String> dataIdOfLaptop = new ArrayList<>();

    public DataIdOfLaptop() {
    }

    public ArrayList<String> createDataId(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-productId=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataIdOfLaptop.add(matcher.group(1));
            }
            if (dataIdOfLaptop.size() == 8) {
                break;
            }
        }
        return dataIdOfLaptop;
    }
}
