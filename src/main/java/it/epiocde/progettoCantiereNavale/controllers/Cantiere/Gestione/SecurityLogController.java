package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.SecurityLog;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.SecurityLogRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione.SecurityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-logs")
public class SecurityLogController {

    @Autowired
    private SecurityLogService securityLogService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllSecurityLogs(Pageable pageable) {
        return DefaultResponse.noMessage(securityLogService.getAllSecurityLogs(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getSecurityLogById(@PathVariable Long id) throws NotFoundException {
        SecurityLog securityLog = securityLogService.getSecurityLogById(id);
        return DefaultResponse.noMessage(securityLog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createSecurityLog(@RequestBody @Validated SecurityLogRequest securityLogRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        }
        SecurityLog createdSecurityLog = securityLogService.createSecurityLog(securityLogRequest);
        return DefaultResponse.noMessage(createdSecurityLog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateSecurityLog(@PathVariable Long id, @RequestBody @Validated SecurityLogRequest securityLogRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        }
        SecurityLog updatedSecurityLog = securityLogService.updateSecurityLog(id, securityLogRequest);
        return DefaultResponse.noMessage(updatedSecurityLog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteSecurityLog(@PathVariable Long id) throws NotFoundException {
        securityLogService.deleteSecurityLog(id);
        String message = "Security log with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
