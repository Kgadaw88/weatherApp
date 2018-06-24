package com.kamilgadawski.appWeather.controller;


import com.kamilgadawski.appWeather.Model.WeatherModel.WeatherModel;
import com.kamilgadawski.appWeather.Model.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("city") String cityName,
                        Model model) {

        WeatherModel weatherModel = weatherService.makeCall(cityName);

//        model.addAttribute("weatherInfo", weatherService.makeCall(cityName).toString());
        model.addAttribute("city", cityName.toString());
        model.addAttribute("temperature", weatherService.temperature(weatherModel) + " *C");
        System.out.println(weatherService.temperature(weatherModel));
        return "index";
    }
}
