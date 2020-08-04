package Data.Tablet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CreateDataOfTablet {
    private ArrayList<String> data;

    public CreateDataOfTablet() {
        data = new ArrayList<>();
    }

    public ArrayList<String> createData() throws IOException {
        URL url = new URL("https://www.thegioididong.com/may-tinh-bang");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }
}
