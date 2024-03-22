package it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzione;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Manutenzione.MaterialeUtilizzatoManutenzioneRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzioneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialeUtilizzatoManutenzioneService {

    @Autowired
    private MaterialeUtilizzatoManutenzioneRepo materialeUtilizzatoManutenzioneRepository;

    @Autowired
    private MaintenanceService maintenanceService;

    public MaterialeUtilizzatoManutenzione createMaterialeUtilizzatoManutenzione(MaterialeUtilizzatoManutenzioneRequest request) throws NotFoundException {
        MaterialeUtilizzatoManutenzione materiale = new MaterialeUtilizzatoManutenzione();
        materiale.setNome(request.getNome());
        materiale.setQuantitaUtilizzata(request.getQuantitaUtilizzata());

        // Ottieni la manutenzione
        Maintenance maintenance = maintenanceService.getMaintenanceById(request.getMaintenanceId());
        materiale.setMaintenance(maintenance);

        // Aggiungi l'articolo di magazzino utilizzato
        // ArticoloMagazzino articoloMagazzino = articoloMagazzinoService.getArticoloMagazzinoById(request.getArticoloMagazzinoId());
        // materiale.setArticoloMagazzino(articoloMagazzino);

        return materialeUtilizzatoManutenzioneRepository.save(materiale);
    }

    public void deleteMaterialeUtilizzatoManutenzione(Long id) throws NotFoundException {
        MaterialeUtilizzatoManutenzione materiale = getMaterialeUtilizzatoManutenzioneById(id);
        materialeUtilizzatoManutenzioneRepository.delete(materiale);
    }

    public MaterialeUtilizzatoManutenzione getMaterialeUtilizzatoManutenzioneById(Long id) throws NotFoundException {
        return materialeUtilizzatoManutenzioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Materiale utilizzato in manutenzione not found"));
    }

    public List<MaterialeUtilizzatoManutenzione> getAllMaterialiUtilizzatiManutenzione() {
        return materialeUtilizzatoManutenzioneRepository.findAll();
    }

    public MaterialeUtilizzatoManutenzione updateMaterialeUtilizzatoManutenzione(Long id, MaterialeUtilizzatoManutenzioneRequest request) throws NotFoundException {
        MaterialeUtilizzatoManutenzione materiale = getMaterialeUtilizzatoManutenzioneById(id);
        materiale.setNome(request.getNome());
        materiale.setQuantitaUtilizzata(request.getQuantitaUtilizzata());

        // Aggiorna la manutenzione se necessario
        if (!materiale.getMaintenance().getId().equals(request.getMaintenanceId())) {
            Maintenance maintenance = maintenanceService.getMaintenanceById(request.getMaintenanceId());
            materiale.setMaintenance(maintenance);
        }

        // Aggiorna l'articolo di magazzino utilizzato se necessario
        // if (!materiale.getArticoloMagazzino().getId().equals(request.getArticoloMagazzinoId())) {
        //     ArticoloMagazzino articoloMagazzino = articoloMagazzinoService.getArticoloMagazzinoById(request.getArticoloMagazzinoId());
        //     materiale.setArticoloMagazzino(articoloMagazzino);
        // }

        return materialeUtilizzatoManutenzioneRepository.save(materiale);
    }
}
