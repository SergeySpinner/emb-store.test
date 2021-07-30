package projectFiles.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    private double speed;

    public Wind(@JsonProperty("speed") double speed){
        this.speed = speed;
    }
}
