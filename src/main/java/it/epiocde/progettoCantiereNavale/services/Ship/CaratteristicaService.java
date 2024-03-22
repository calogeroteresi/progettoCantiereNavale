package it.epiocde.progettoCantiereNavale.services.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Caratteristica;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Ship.CaratteristicaRepo;
import it.epiocde.progettoCantiereNavale.requests.Ship.CaratteristicaRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaratteristicaService {

    @Autowired
    private CaratteristicaRepo caratteristicaRepository;

    @Autowired
    private ShipService shipService;

    public Caratteristica createCaratteristica(CaratteristicaRequest request) throws NotFoundException {
        Caratteristica caratteristica = mapRequestToEntity(request);
        return caratteristicaRepository.save(caratteristica);
    }

    public Caratteristica updateCaratteristica(Long id, CaratteristicaRequest request) throws NotFoundException {
        Caratteristica caratteristica = getCaratteristicaById(id);
        Caratteristica updatedCaratteristica = mapRequestToEntity(request);
        BeanUtils.copyProperties(updatedCaratteristica, caratteristica, "id");
        return caratteristicaRepository.save(caratteristica);
    }

    public void deleteCaratteristica(Long id) throws NotFoundException {
        Caratteristica caratteristica = getCaratteristicaById(id);
        caratteristicaRepository.delete(caratteristica);
    }

    public Caratteristica getCaratteristicaById(Long id) throws NotFoundException {
        return caratteristicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Caratteristica nave non trovata"));
    }

    private Caratteristica mapRequestToEntity(CaratteristicaRequest request) throws NotFoundException {
        Caratteristica caratteristica = new Caratteristica();
        caratteristica.setShip(shipService.getShipById(request.getShipId()));
        caratteristica.setEquipaggiamentiElettrici(request.getEquipaggiamentiElettrici());
        caratteristica.setElettronici(request.getElettronici());
        caratteristica.setEquipaggiamentiInterni(request.getEquipaggiamentiInterni());
        caratteristica.setDotazioniEsterne(request.getDotazioniEsterne());
        caratteristica.setCertificazioneCE(request.getCertificazioneCE());
        caratteristica.setCabine(request.getCabine());
        caratteristica.setDoppioAncoraggio(request.getDoppioAncoraggio());
        caratteristica.setCuccetteDoppie(request.getCuccetteDoppie());
        caratteristica.setCuccetteSingole(request.getCuccetteSingole());
        caratteristica.setLocaleWCBagni(request.getLocaleWCBagni());
        caratteristica.setNumeroMassimoPasseggeri(request.getNumeroMassimoPasseggeri());
        caratteristica.setPostiASedere(request.getPostiASedere());
        caratteristica.setSerbatoioAcqua(request.getSerbatoioAcqua());
        caratteristica.setFormaScafo(request.getFormaScafo());
        caratteristica.setMulinello(request.getMulinello());
        caratteristica.setGaranziaScafo(request.getGaranziaScafo());
        return caratteristica;
    }
}
