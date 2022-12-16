package Lesson24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<PriceInfo> priceInfoList = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/productstar-team/javaTwo/master/resources/monthly_IBM.csv");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            boolean firstLine = true;
            HeaderInfo headerInfo = new HeaderInfo();
            while ((line = bufferedReader.readLine()) != null) {
                String[] curData = line.split(",");
                if (firstLine) {
                    headerInfo = new HeaderInfo(curData);
                    firstLine = false;
                } else {
                    priceInfoList.add(new PriceInfo(curData, headerInfo));
                }
            }
            String minPriceDate = priceInfoList.stream().sorted().findFirst().get().getTimeStamp();
            System.out.println(minPriceDate);
            String maxPriceDate = priceInfoList.stream().sorted().skip(priceInfoList.stream().count()-1).findFirst().get().getTimeStamp();
            System.out.println(maxPriceDate);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class HeaderInfo {
    static final String timeStampHeader = "timestamp", closePriceHeader = "close";

    private int timeStampPosition = -1;
    private int closePricePosition = -1;

    public HeaderInfo() {
    }

    public HeaderInfo(String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            String curHeader = headers[i];
            switch (curHeader.toLowerCase()) {
                case timeStampHeader: {
                    this.timeStampPosition = i;
                    break;
                }
                case closePriceHeader: {
                    this.closePricePosition = i;
                    break;
                }
            }
        }
        if (this.timeStampPosition == -1) {
            throw new RuntimeException("TimeStamp header not found");
        }
        if (this.closePricePosition == -1) {
            throw new RuntimeException("close header not found");
        }
    }

    public int getTimeStampPosition() {
        return timeStampPosition;
    }

    public void setTimeStampPosition(int timeStampPosition) {
        this.timeStampPosition = timeStampPosition;
    }

    public int getClosePricePosition() {
        return closePricePosition;
    }

    public void setClosePricePosition(int closePricePosition) {
        this.closePricePosition = closePricePosition;
    }

}

class PriceInfo implements Comparable {
    private String TimeStamp;
    private float price;

    public PriceInfo(String[] lineData, HeaderInfo headerInfo) {
        this.price = Float.parseFloat(lineData[headerInfo.getClosePricePosition()]);
        this.TimeStamp = lineData[headerInfo.getTimeStampPosition()];
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.TimeStamp = timeStamp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == getClass()) {
            return (int) (this.getPrice() - ((PriceInfo) o).getPrice());
        } else return -1;
    }
}