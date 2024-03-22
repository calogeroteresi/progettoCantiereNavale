package it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.WeatherForecast;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.WeatherForecastRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.WeatherForecastRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherForecastService {

    @Autowired
    private WeatherForecastRepo weatherForecastRepository;

    public WeatherForecast getWeatherForecastById(Long id) throws NotFoundException {
        Optional<WeatherForecast> optionalWeatherForecast = weatherForecastRepository.findById(id);
        if (optionalWeatherForecast.isEmpty()) {
            throw new NotFoundException("Weather forecast not found with ID: " + id);
        }
        return optionalWeatherForecast.get();
    }

    public List<WeatherForecast> getAllWeatherForecasts() {
        return weatherForecastRepository.findAll();
    }

    public WeatherForecast createWeatherForecast(WeatherForecastRequest weatherForecastRequest) {
        WeatherForecast weatherForecast = new WeatherForecast();
        mapWeatherForecastRequestToEntity(weatherForecastRequest, weatherForecast);
        return weatherForecastRepository.save(weatherForecast);
    }

    public WeatherForecast updateWeatherForecast(Long id, WeatherForecastRequest weatherForecastRequest) throws NotFoundException {
        WeatherForecast weatherForecast = getWeatherForecastById(id);
        mapWeatherForecastRequestToEntity(weatherForecastRequest, weatherForecast);
        return weatherForecastRepository.save(weatherForecast);
    }

    public void deleteWeatherForecast(Long id) throws NotFoundException {
        WeatherForecast weatherForecast = getWeatherForecastById(id);
        weatherForecastRepository.delete(weatherForecast);
    }

    private void mapWeatherForecastRequestToEntity(WeatherForecastRequest request, WeatherForecast entity) {
        entity.setForecastDate(request.getForecastDate());
        entity.setLocation(request.getLocation());
        entity.setTemperature(request.getTemperature());
        entity.setDescription(request.getDescription());
        // Aggiungi altre associazioni qui se necessario
    }
}
