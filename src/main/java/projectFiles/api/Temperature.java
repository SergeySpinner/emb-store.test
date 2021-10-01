package projectFiles.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private double temp; // температура в данный момент
    private double temp_min; // минимальная
    private double temp_max; // максимальная температура
    private double feels_like; // ощущается как
    private int humidity; // влажность

    public Temperature(@JsonProperty("temp") double temp, @JsonProperty("temp_min") double temp_min,
                       @JsonProperty("temp_max") double temp_max, @JsonProperty("feels_like") double feels_like,
                       @JsonProperty("humidity") int humidity) {
        this.temp = (double) ((int) ((temp - 273.15) * 10)) / 10;
        this.feels_like = (double) ((int) ((feels_like - 273.15) * 10)) / 10;
        this.temp_min = (double) ((int) ((temp_min - 273.15) * 10)) / 10;
        this.temp_max = (double) ((int) ((temp_max - 273.15) * 10)) / 10;
        this.humidity = humidity;
    }
}
