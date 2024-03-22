package it.epiocde.progettoCantiereNavale.controllers.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Certificate;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Ship.CertificateRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Ship.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllCertificates() {
        List<Certificate> certificates = certificateService.getAllCertificates();
        return DefaultResponse.noMessage(certificates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getCertificateById(@PathVariable Long id) throws NotFoundException {
        Certificate certificate = certificateService.getCertificateById(id)
                .orElseThrow(() -> new NotFoundException("Certificate not found with ID: " + id));
        return DefaultResponse.noMessage(certificate, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<DefaultResponse> createCertificate(@RequestBody @Validated CertificateRequest certificateRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Certificate createdCertificate = certificateService.createCertificate(certificateRequest);
        return DefaultResponse.noMessage(createdCertificate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteCertificate(@PathVariable Long id) throws NotFoundException {
        certificateService.deleteCertificate(id);
        String message = "Certificate with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateCertificate(@PathVariable Long id, @RequestBody @Validated CertificateRequest certificateRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Certificate updatedCertificate = certificateService.updateCertificate(id, certificateRequest)
                .orElseThrow(() -> new NotFoundException("Certificate not found with ID: " + id));
        return DefaultResponse.noMessage(updatedCertificate, HttpStatus.OK);
    }

}
