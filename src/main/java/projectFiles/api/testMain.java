package projectFiles.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class testMain {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Energodar&appid=" +
                "b5aa2303deb0fd11996cc9d5469cf8bd");
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext())
            sb.append(sc.next());
        String result = sb.toString();
        System.out.println(result);

        result = result.replaceAll("<[>^]*", "");
        System.out.println(result);
        System.out.println(new Date(1627579211L * 1000));
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData wd = objectMapper.readValue(result, WeatherData.class);
        System.out.println(wd.toString());
    }
}
