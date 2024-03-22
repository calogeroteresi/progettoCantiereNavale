package it.epiocde.progettoCantiereNavale.services.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Certificate;
import it.epiocde.progettoCantiereNavale.repositories.Ship.CertificateRepo;
import it.epiocde.progettoCantiereNavale.requests.Ship.CertificateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepo certificateRepository;

    @Autowired
    public CertificateService(CertificateRepo certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    public Certificate createCertificate(@NotNull @Valid CertificateRequest certificateRequest) {
        Certificate certificate = mapRequestToEntity(certificateRequest);
        return certificateRepository.save(certificate);
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }

    private Certificate mapRequestToEntity(CertificateRequest certificateRequest) {
        Certificate certificate = new Certificate();
        certificate.setTipo(certificateRequest.getTipo());
        certificate.setDescrizione(certificateRequest.getDescrizione());
        certificate.setNumero(certificateRequest.getNumero());
        certificate.setEnteRilascio(certificateRequest.getEnteRilascio());

        // Imposta la relazione con la nave
        // Assicurati di gestire questa parte in base alla tua logica di business
        // In questo esempio, si presume che l'ID della nave sia già presente nella richiesta del certificato
        // Quindi viene semplicemente impostato l'ID della nave nel certificato senza effettuare ulteriori controlli
        certificate.getShip().setId(certificateRequest.getShipId());

        return certificate;
    }
}
