package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.TaskManutenzione;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.TaskManutenzioneRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione.TaskManutenzioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance/task")
public class TaskManutenzioneController {

    @Autowired
    private TaskManutenzioneService taskManutenzioneService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getTaskManutenzioneById(@PathVariable Long id) throws NotFoundException {
        TaskManutenzione taskManutenzione = taskManutenzioneService.getTaskManutenzioneById(id);
        return DefaultResponse.noMessage(taskManutenzione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllTaskManutenzione() {
        List<TaskManutenzione> taskManutenzioni = taskManutenzioneService.getAllTaskManutenzione();
        return DefaultResponse.noMessage(taskManutenzioni, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createTaskManutenzione(@RequestBody @Validated TaskManutenzioneRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        TaskManutenzione createdTask = taskManutenzioneService.createTaskManutenzione(request);
        return DefaultResponse.noMessage(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateTaskManutenzione(@PathVariable Long id, @RequestBody @Validated TaskManutenzioneRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        TaskManutenzione updatedTask = taskManutenzioneService.updateTaskManutenzione(id, request);
        return DefaultResponse.noMessage(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteTaskManutenzione(@PathVariable Long id) throws NotFoundException {
        taskManutenzioneService.deleteTaskManutenzione(id);
        String message = "Task di manutenzione with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
