package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.WeatherForecast;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.WeatherForecastRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather-forecasts")
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getWeatherForecastById(@PathVariable Long id) throws NotFoundException {
        WeatherForecast weatherForecast = weatherForecastService.getWeatherForecastById(id);
        return DefaultResponse.noMessage(weatherForecast, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllWeatherForecasts() {
        List<WeatherForecast> weatherForecasts = weatherForecastService.getAllWeatherForecasts();
        return DefaultResponse.noMessage(weatherForecasts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createWeatherForecast(@RequestBody @Validated WeatherForecastRequest weatherForecastRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        WeatherForecast createdWeatherForecast = weatherForecastService.createWeatherForecast(weatherForecastRequest);
        return DefaultResponse.noMessage(createdWeatherForecast, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateWeatherForecast(@PathVariable Long id, @RequestBody @Validated WeatherForecastRequest weatherForecastRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        WeatherForecast updatedWeatherForecast = weatherForecastService.updateWeatherForecast(id, weatherForecastRequest);
        return DefaultResponse.noMessage(updatedWeatherForecast, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteWeatherForecast(@PathVariable Long id) throws NotFoundException {
        weatherForecastService.deleteWeatherForecast(id);
        String message = "Weather forecast with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
