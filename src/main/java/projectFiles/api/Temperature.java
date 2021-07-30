package projectFiles.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private double temp;
    private double temp_min;
    private double temp_max;
    private double feels_like;

    public Temperature(@JsonProperty("temp") double temp, @JsonProperty("temp_min") double temp_min,
                       @JsonProperty("temp_max") double temp_max, @JsonProperty("feels_like") double feels_like) {
        this.temp = Math.round(temp - 273.15);
        this.feels_like = feels_like - 273.15;
        this.temp_min = temp_min - 273.15;
        this.temp_max = temp_max - 273.15;
    }
}
