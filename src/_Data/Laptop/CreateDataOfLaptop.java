package _Data.Laptop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CreateDataOfLaptop {
    private final ArrayList<String> data = new ArrayList<>();

    public CreateDataOfLaptop() {
    }

    public ArrayList<String> createData() throws IOException {
        URL url = new URL("https://www.thegioididong.com/laptop");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }
}
