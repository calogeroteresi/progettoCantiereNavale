package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.SchedaLavoroDipendenti;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.WorkScheduleRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-schedules")
public class WorkScheduleController {

    @Autowired
    private WorkScheduleService workScheduleService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getWorkScheduleById(@PathVariable Long id) throws NotFoundException {
        SchedaLavoroDipendenti workSchedule = workScheduleService.getWorkScheduleById(id);
        return DefaultResponse.noMessage(workSchedule, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllWorkSchedules() {
        List<SchedaLavoroDipendenti> workSchedules = workScheduleService.getAllWorkSchedules();
        return DefaultResponse.noMessage(workSchedules, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createWorkSchedule(@RequestBody @Validated WorkScheduleRequest workScheduleRequest, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        SchedaLavoroDipendenti createdWorkSchedule = workScheduleService.createWorkSchedule(workScheduleRequest);
        return DefaultResponse.noMessage(createdWorkSchedule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateWorkSchedule(@PathVariable Long id, @RequestBody @Validated WorkScheduleRequest workScheduleRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        SchedaLavoroDipendenti updatedWorkSchedule = workScheduleService.updateWorkSchedule(id, workScheduleRequest);
        return DefaultResponse.noMessage(updatedWorkSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteWorkSchedule(@PathVariable Long id) throws NotFoundException {
        workScheduleService.deleteWorkSchedule(id);
        String message = "Work schedule with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
