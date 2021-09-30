package projectFiles.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WeatherInfo {
    public static WeatherData getWeather() throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Energodar&appid=" +
                "b5aa2303deb0fd11996cc9d5469cf8bd");
        Scanner sc = new Scanner(url.openStream());

        StringBuffer sb = new StringBuffer();
        while (sc.hasNext())
            sb.append(sc.next());
        String result = sb.toString();

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(result, WeatherData.class);
        return weatherData;
    }
}
