package com.kamilgadawski.appWeather.Model.WeatherModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TempStats {

    @JsonProperty("temp")
    private float temperature;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    private int clouds;
}
