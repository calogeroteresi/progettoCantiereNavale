package it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Manutenzione.MaintenanceRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.MaintenanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepo maintenanceRepository;

    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getMaintenanceById(Long id) throws NotFoundException {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Maintenance not found"));
    }

    public Maintenance createMaintenance(MaintenanceRequest request) throws NotFoundException {
        Maintenance maintenance = new Maintenance();
        maintenance.setTipo(request.getTipo());
        maintenance.setDataInizio(request.getDataInizio());
        maintenance.setDataFine(request.getDataFine());
        maintenance.setDescrizione(request.getDescrizione());
        maintenance.setCosto(request.getCosto());

        // Aggiungi il collegamento alla nave
        // maintenance.setShip(ship);

        // Aggiungi il collegamento al report di incidente
        // maintenance.setIncidentReport(incidentReport);

        // Aggiungi il collegamento ai dipendenti
        // maintenance.setEmployees(employees);

        return maintenanceRepository.save(maintenance);
    }

    public void deleteMaintenance(Long id) throws NotFoundException {
        Maintenance maintenance = getMaintenanceById(id);
        maintenanceRepository.delete(maintenance);
    }

    public Maintenance updateMaintenance(Long id, MaintenanceRequest request) throws NotFoundException {
        Maintenance maintenance = getMaintenanceById(id);
        maintenance.setTipo(request.getTipo());
        maintenance.setDataInizio(request.getDataInizio());
        maintenance.setDataFine(request.getDataFine());
        maintenance.setDescrizione(request.getDescrizione());
        maintenance.setCosto(request.getCosto());

        // Aggiorna i collegamenti se necessario
        // maintenance.setShip(ship);
        // maintenance.setIncidentReport(incidentReport);
        // maintenance.setEmployees(employees);

        return maintenanceRepository.save(maintenance);
    }
}
