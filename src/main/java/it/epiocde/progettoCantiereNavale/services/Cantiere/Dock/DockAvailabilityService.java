package it.epiocde.progettoCantiereNavale.services.Cantiere.Dock;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.Dock;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.DockAvailability;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Dock.DockAvailabilityRepo;
import it.epiocde.progettoCantiereNavale.repositories.Dock.DockRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock.DockAvailabilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DockAvailabilityService {
    @Autowired
    private DockAvailabilityRepo dockAvailabilityRepository;

    @Autowired
    private DockRepo dockRepository;

    public DockAvailability getDockAvailabilityById(Long id) throws NotFoundException {
        return dockAvailabilityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dock not found with ID: " + id));
    }

    public DockAvailability createDockAvailability(DockAvailabilityRequest dockAvailabilityRequest) throws NotFoundException {
        DockAvailability dockAvailability = new DockAvailability();
        Dock dock = dockRepository.findById(dockAvailabilityRequest.getDockId())
                .orElseThrow(() -> new NotFoundException("Dock not found with ID: " + dockAvailabilityRequest.getDockId()));

        dockAvailability.setDock(dock);
        mapDockAvailabilityRequestToEntity(dockAvailabilityRequest, dockAvailability);

        return dockAvailabilityRepository.save(dockAvailability);
    }

    public DockAvailability updateDockAvailability(Long id, DockAvailabilityRequest dockAvailabilityRequest) throws NotFoundException {
        Optional<DockAvailability> optionalDockAvailability = dockAvailabilityRepository.findById(id);
        if (!optionalDockAvailability.isPresent()) {
            throw new NotFoundException("Dock Availability not found with ID: " + id);
        }

        DockAvailability dockAvailability = optionalDockAvailability.get();
        Dock dock = dockRepository.findById(dockAvailabilityRequest.getDockId())
                .orElseThrow(() -> new NotFoundException("Dock not found with ID: " + dockAvailabilityRequest.getDockId()));

        dockAvailability.setDock(dock);
        mapDockAvailabilityRequestToEntity(dockAvailabilityRequest, dockAvailability);

        return dockAvailabilityRepository.save(dockAvailability);
    }

    public void deleteDockAvailability(Long id) throws NotFoundException {
        Optional<DockAvailability> optionalDockAvailability = dockAvailabilityRepository.findById(id);
        if (!optionalDockAvailability.isPresent()) {
            throw new NotFoundException("Dock Availability not found with ID: " + id);
        }

        dockAvailabilityRepository.deleteById(id);
    }

    private void mapDockAvailabilityRequestToEntity(DockAvailabilityRequest request, DockAvailability entity) {
        entity.setPostiOccupati(request.getPostiOccupati());
        entity.setPostiDisponibili(request.getPostiDisponibili());
        entity.setDisponibile(request.isDisponibile());
        entity.setInManutenzione(request.isInManutenzione());
        entity.setDataInizio(request.getDataInizio());
        entity.setDataFine(request.getDataFine());
        entity.setRiduzioneCapacitaDovutaAllaManutenzione(request.isRiduzioneCapacitaDovutaAllaManutenzione());
        entity.setCapacitaRidotta(request.getCapacitaRidotta());
    }
}
