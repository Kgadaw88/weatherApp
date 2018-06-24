package com.kamilgadawski.appWeather.Model;

import com.kamilgadawski.appWeather.Model.WeatherModel.TempStats;
import com.kamilgadawski.appWeather.Model.WeatherModel.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api_key}")
    private String appKey;
    private RestTemplate restTemplate;

    public WeatherService() {
        restTemplate = new RestTemplate();
    }

    public WeatherModel makeCall(String city){
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + appKey, WeatherModel.class);
    }

    public String temperature(WeatherModel weatherModel){
        return String.format("%.1f", weatherModel.getGlobalStats().getTemperature() - 273.15);
    }
}
