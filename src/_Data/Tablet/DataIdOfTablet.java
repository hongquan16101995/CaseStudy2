package _Data.Tablet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataIdOfTablet {
    private final ArrayList<String> dataIdOfTablet = new ArrayList<>();

    public DataIdOfTablet() {
    }

    public ArrayList<String> createDataId(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-productId=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataIdOfTablet.add(matcher.group(1));
            }
            if (dataIdOfTablet.size() == 8) {
                break;
            }
        }
        return dataIdOfTablet;
    }
}
