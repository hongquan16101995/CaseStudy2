package _Data.Laptop;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataPriceOfLaptop {
    private ArrayList<String> dataPriceOfLaptop;

    public DataPriceOfLaptop() {
        dataPriceOfLaptop = new ArrayList<>();
    }

    public ArrayList<String> createDataPrice(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-price=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataPriceOfLaptop.add(matcher.group(1));
            }
            if (dataPriceOfLaptop.size() == 8) {
                break;
            }
        }
        return dataPriceOfLaptop;
    }
}
