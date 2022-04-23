import com.opencsv.CSVReaderHeaderAware;

import java.io.FileReader;
import java.util.Map;

public class Ex13 {
    public static void main(String[] args) {
        try {
            Map<String, String> values = new CSVReaderHeaderAware(new FileReader("data.csv")).readMap();

            System.out.println(values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
