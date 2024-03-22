package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.IncidenteReportRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione.IncidentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incident-reports")
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllIncidentReports() {
        List<IncidentReport> incidentReports = incidentReportService.getAllIncidentReports();
        return DefaultResponse.noMessage(incidentReports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getIncidentReportById(@PathVariable Long id) throws NotFoundException {
        IncidentReport incidentReport = incidentReportService.getIncidentReportById(id);
        return DefaultResponse.noMessage(incidentReport, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createIncidentReport(@RequestBody @Validated IncidenteReportRequest incidentReportRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        IncidentReport createdIncidentReport = incidentReportService.createIncidentReport(incidentReportRequest);
        return DefaultResponse.noMessage(createdIncidentReport, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteIncidentReport(@PathVariable Long id) throws NotFoundException {
        incidentReportService.deleteIncidentReport(id);
        String message = "Incident report with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateIncidentReport(@PathVariable Long id, @RequestBody @Validated IncidenteReportRequest incidentReportRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        IncidentReport updatedIncidentReport = incidentReportService.updateIncidentReport(id, incidentReportRequest);
        return DefaultResponse.noMessage(updatedIncidentReport, HttpStatus.OK);
    }
}
