package it.epiocde.progettoCantiereNavale.repositories.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepo extends JpaRepository<WeatherForecast, Long>, PagingAndSortingRepository<WeatherForecast, Long> {
}
