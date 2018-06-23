package com.kamilgadawski.appWeather.controller;


import com.kamilgadawski.appWeather.Model.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return weatherService.makeCall("Kraków");
    }
}
