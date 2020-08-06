package Data.SmartPhone;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataIdOfSmartphone {
    private ArrayList<String> dataIdOfSmartphone;

    public DataIdOfSmartphone() {
        dataIdOfSmartphone = new ArrayList<>();
    }

    public ArrayList<String> createDataId(ArrayList<String> data) {
        for (String string : data) {
            Pattern pattern = Pattern.compile("data-productId=\"(.*?)\"");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                dataIdOfSmartphone.add(matcher.group(1));
            }
            if (dataIdOfSmartphone.size() == 8) {
                break;
            }
        }
        return dataIdOfSmartphone;
    }
}
