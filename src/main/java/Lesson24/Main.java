package Lesson24;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<PriceInfo> priceInfoList = NetUtils.GetPriceInfoFromURL("https://raw.githubusercontent.com/productstar-team/javaTwo/master/resources/monthly_IBM.csv");
        String minPriceDate = priceInfoList.stream().sorted().findFirst().get().getTimeStamp();
        System.out.println(minPriceDate);
        String maxPriceDate = priceInfoList.stream().sorted().skip(priceInfoList.stream().count() - 1).findFirst().get().getTimeStamp();
        System.out.println(maxPriceDate);

    }
}

