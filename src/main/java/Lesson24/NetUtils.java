package Lesson24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class NetUtils {
    public static List<PriceInfo> GetPriceInfoFromURL(String URL) {
        List<PriceInfo> result = new ArrayList<>();
        List<String> fileLines = getStringsFromURL(URL);
        boolean firstLine = true;
        HeaderInfo headerInfo = new HeaderInfo();
        for (String line : fileLines) {
            String[] curData = line.split(",");
            if (firstLine) {
                headerInfo = new HeaderInfo(curData);
                firstLine = false;
            } else {
                result.add(new PriceInfo(curData, headerInfo));
            }
        }
        return result;
    }

    private static List<String> getStringsFromURL(String URL) {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(URL);
            URLConnection urlConnection = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;

        return result;
    }
}
