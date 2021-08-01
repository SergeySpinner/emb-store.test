package projectFiles.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("main")
    private Temperature temperature;
    @JsonProperty("name")
    private String cityName;

    public WeatherData(@JsonProperty("wind") Wind wind, @JsonProperty("main") Temperature temperature) {
        this.temperature = temperature;
        this.wind = wind;
    }
}
