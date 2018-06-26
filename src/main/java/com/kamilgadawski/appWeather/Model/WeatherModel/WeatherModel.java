package com.kamilgadawski.appWeather.Model.WeatherModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherModel {

    @JsonProperty("main")
    private TempStats globalStats;
}
