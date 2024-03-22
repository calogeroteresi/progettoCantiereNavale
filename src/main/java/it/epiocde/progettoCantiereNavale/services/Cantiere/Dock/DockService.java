package it.epiocde.progettoCantiereNavale.services.Cantiere.Dock;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.Dock;
import it.epiocde.progettoCantiereNavale.repositories.Dock.DockRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock.DockRequest;
import it.epiocde.progettoCantiereNavale.enums.StatoDock;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DockService {
    @Autowired
    private DockRepo dockRepository;

    public Page<Dock> getAllDocks(Pageable pageable) {
        return dockRepository.findAll(pageable);
    }

    public Dock getDockById(Long id) throws NotFoundException {
        return dockRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dock not found with ID: " + id));
    }

    public Dock createDock(DockRequest dockRequest) {
        Dock dock = new Dock();
        dock.setDenominazione(dockRequest.getDenominazione());
        dock.setLatitudine(dockRequest.getLatitudine());
        dock.setLongitudine(dockRequest.getLongitudine());
        dock.setIndirizzoCompleto(dockRequest.getIndirizzoCompleto());
        dock.setProvincia(dockRequest.getProvincia());
        dock.setComune(dockRequest.getComune());
        dock.setCapacitaMassima(dockRequest.getCapacitaMassima());
        dock.setStato(dockRequest.getStato());

        return dockRepository.save(dock);
    }

    public void deleteDock(Long id) throws NotFoundException {
        Dock dock = getDockById(id);
        dockRepository.delete(dock);
    }

    public Dock updateDock(Long id, DockRequest dockRequest) throws NotFoundException {
        Dock dock = getDockById(id);
        dock.setDenominazione(dockRequest.getDenominazione());
        dock.setLatitudine(dockRequest.getLatitudine());
        dock.setLongitudine(dockRequest.getLongitudine());
        dock.setIndirizzoCompleto(dockRequest.getIndirizzoCompleto());
        dock.setProvincia(dockRequest.getProvincia());
        dock.setComune(dockRequest.getComune());
        dock.setCapacitaMassima(dockRequest.getCapacitaMassima());
        dock.setStato(dockRequest.getStato());

        return dockRepository.save(dock);
    }
}
