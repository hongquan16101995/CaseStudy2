package _Data.Tablet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataPriceOfTablet {
    private ArrayList<String> dataPriceOfTablet;

    public DataPriceOfTablet() {
        dataPriceOfTablet = new ArrayList<>();
    }

    public ArrayList<String> createDataPrice(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-price=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataPriceOfTablet.add(matcher.group(1));
            }
            if (dataPriceOfTablet.size() == 8) {
                break;
            }
        }
        return dataPriceOfTablet;
    }
}
