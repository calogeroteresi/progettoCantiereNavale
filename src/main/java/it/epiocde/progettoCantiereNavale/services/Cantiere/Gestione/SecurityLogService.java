package it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.SecurityLog;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.SecurityLogRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.SecurityLogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityLogService {

    @Autowired
    private SecurityLogRepo securityLogRepository;

    public SecurityLog getSecurityLogById(Long id) throws NotFoundException {
        Optional<SecurityLog> optionalSecurityLog = securityLogRepository.findById(id);
        if (optionalSecurityLog.isEmpty()) {
            throw new NotFoundException("Security log not found with ID: " + id);
        }
        return optionalSecurityLog.get();
    }

    public List<SecurityLog> getAllSecurityLogs() {
        return securityLogRepository.findAll();
    }

    public SecurityLog createSecurityLog(SecurityLogRequest securityLogRequest) {
        SecurityLog securityLog = new SecurityLog();
        mapSecurityLogRequestToEntity(securityLogRequest, securityLog);
        return securityLogRepository.save(securityLog);
    }

    public SecurityLog updateSecurityLog(Long id, SecurityLogRequest securityLogRequest) throws NotFoundException {
        SecurityLog securityLog = getSecurityLogById(id);
        mapSecurityLogRequestToEntity(securityLogRequest, securityLog);
        return securityLogRepository.save(securityLog);
    }

    public void deleteSecurityLog(Long id) throws NotFoundException {
        SecurityLog securityLog = getSecurityLogById(id);
        securityLogRepository.delete(securityLog);
    }

    private void mapSecurityLogRequestToEntity(SecurityLogRequest request, SecurityLog entity) {
        entity.setTimestamp(request.getTimestamp());
        entity.setAction(request.getAction());
        entity.setDescription(request.getDescription());
        // Aggiungi altre associazioni qui se necessario
    }
}
