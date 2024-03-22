package it.epiocde.progettoCantiereNavale.services.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Certificate;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
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
        Certificate certificate = new Certificate();
        mapRequestToEntity(certificate, certificateRequest);
        return certificateRepository.save(certificate);
    }

    public Optional<Certificate> updateCertificate(Long id, @NotNull @Valid CertificateRequest certificateRequest) throws NotFoundException {
        Optional<Certificate> optionalCertificate = certificateRepository.findById(id);
        if (!optionalCertificate.isPresent()) {
            throw new NotFoundException("Certificate not found with ID: " + id);
        }

        Certificate certificate = optionalCertificate.get();
        mapRequestToEntity(certificate, certificateRequest); // Update the certificate entity with the new values

        return Optional.of(certificateRepository.save(certificate));
    }

    private void mapRequestToEntity(Certificate certificate, CertificateRequest certificateRequest) {
        // Update the fields of the certificate entity with values from the request
        certificate.setTipo(certificateRequest.getTipo());
        certificate.setDescrizione(certificateRequest.getDescrizione());
        certificate.setNumero(certificateRequest.getNumero());
        certificate.setEnteRilascio(certificateRequest.getEnteRilascio());
        // Non impostare l'ID della nave qui, poiché l'ID della nave non dovrebbe essere modificato durante l'aggiornamento
    }



    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
