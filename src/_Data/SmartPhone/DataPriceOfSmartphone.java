package _Data.SmartPhone;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataPriceOfSmartphone {
    private final ArrayList<String> dataPriceOfSmartphone = new ArrayList<>();

    public DataPriceOfSmartphone() {
    }

    public ArrayList<String> createDataPrice(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-price=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataPriceOfSmartphone.add(matcher.group(1));
            }
            if (dataPriceOfSmartphone.size() == 8) {
                break;
            }
        }
        return dataPriceOfSmartphone;
    }
}
