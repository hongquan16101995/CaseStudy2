package Data.Tablet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataBrandOfTablet {
    private ArrayList<String> dataBrandOfTablet;

    public DataBrandOfTablet() {
        dataBrandOfTablet = new ArrayList<>();
    }

    public ArrayList<String> createDataBrand(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-brand=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataBrandOfTablet.add(matcher.group(1));
            }
            if (dataBrandOfTablet.size() == 8) {
                break;
            }
        }
        return dataBrandOfTablet;
    }
}
