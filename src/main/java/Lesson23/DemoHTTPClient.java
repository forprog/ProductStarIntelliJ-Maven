package Lesson23;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class DemoHTTPClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.apilayer.com/exchangerates_data/latest?symbols=USD")).header("apikey", "wckIb0SSfURl1q37yJCzX1GbjbIn82HU").build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.headers().map());
        System.out.println(response.statusCode());

    }
}
