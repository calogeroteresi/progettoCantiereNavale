package it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.enums.IncidentStatus;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.IncidentReportRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.IncidenteReportRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentReportService {
    @Autowired
    private IncidentReportRepo incidentReportRepo;

    @Autowired
    private EmployeeService employeeService;

    public IncidentReport getIncidentReportById(Long id) throws NotFoundException {
        Optional<IncidentReport> optionalIncidentReport = incidentReportRepo.findById(id);
        if (!optionalIncidentReport.isPresent()) {
            throw new NotFoundException("Incident report not found with ID: " + id);
        }
        return optionalIncidentReport.get();
    }

    public List<IncidentReport> getAllIncidentReports() {
        return incidentReportRepo.findAll();
    }

    public IncidentReport createIncidentReport(IncidenteReportRequest incidentReportRequest) throws NotFoundException {
        IncidentReport incidentReport = new IncidentReport();
        mapIncidentReportRequestToEntity(incidentReportRequest, incidentReport);
        return incidentReportRepo.save(incidentReport);
    }

    public IncidentReport updateIncidentReport(Long id, IncidenteReportRequest incidentReportRequest) throws NotFoundException {
        Optional<IncidentReport> optionalIncidentReport = incidentReportRepo.findById(id);
        if (!optionalIncidentReport.isPresent()) {
            throw new NotFoundException("Incident report not found with ID: " + id);
        }
        IncidentReport incidentReport = optionalIncidentReport.get();
        mapIncidentReportRequestToEntity(incidentReportRequest, incidentReport);
        return incidentReportRepo.save(incidentReport);
    }

    public void deleteIncidentReport(Long id) throws NotFoundException {
        Optional<IncidentReport> optionalIncidentReport = incidentReportRepo.findById(id);
        if (!optionalIncidentReport.isPresent()) {
            throw new NotFoundException("Incident report not found with ID: " + id);
        }
        incidentReportRepo.deleteById(id);
    }

    private void mapIncidentReportRequestToEntity(IncidenteReportRequest request, IncidentReport entity) throws NotFoundException {
        entity.setReportedAt(request.getReportedAt());
        entity.setDescription(request.getDescription());
        entity.setLocation(request.getLocation());
        entity.setStatus(request.getStatus());

        if (request.getReportedById() != null) {
            Employee reportedBy = employeeService.getEmployeeById(request.getReportedById());
            entity.setReportedBy(reportedBy);
        }
        // Gestire altri ID e associazioni se necessario
    }
}
