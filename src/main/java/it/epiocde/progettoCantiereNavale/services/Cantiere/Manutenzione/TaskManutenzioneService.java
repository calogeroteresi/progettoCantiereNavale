package it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.TaskManutenzione;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Manutenzione.TaskManutenzioneRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.TaskManutenzioneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManutenzioneService {

    @Autowired
    private TaskManutenzioneRepo taskManutenzioneRepository;

    @Autowired
    private MaintenanceService maintenanceService;

    public TaskManutenzione createTaskManutenzione(TaskManutenzioneRequest request) throws NotFoundException {
        TaskManutenzione task = new TaskManutenzione();
        task.setDescrizione(request.getDescrizione());
        task.setDettagli(request.getDettagli());
        task.setCompletato(request.isCompletato());

        // Ottieni la manutenzione
        Maintenance maintenance = maintenanceService.getMaintenanceById(request.getMaintenanceId());
        task.setMaintenance(maintenance);

        return taskManutenzioneRepository.save(task);
    }

    public void deleteTaskManutenzione(Long id) throws NotFoundException {
        TaskManutenzione task = getTaskManutenzioneById(id);
        taskManutenzioneRepository.delete(task);
    }

    public TaskManutenzione getTaskManutenzioneById(Long id) throws NotFoundException {
        return taskManutenzioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task di manutenzione non trovato"));
    }

    public List<TaskManutenzione> getAllTaskManutenzione() {
        return taskManutenzioneRepository.findAll();
    }

    public TaskManutenzione updateTaskManutenzione(Long id, TaskManutenzioneRequest request) throws NotFoundException {
        TaskManutenzione task = getTaskManutenzioneById(id);
        task.setDescrizione(request.getDescrizione());
        task.setDettagli(request.getDettagli());
        task.setCompletato(request.isCompletato());

        // Aggiorna la manutenzione se necessario
        if (!task.getMaintenance().getId().equals(request.getMaintenanceId())) {
            Maintenance maintenance = maintenanceService.getMaintenanceById(request.getMaintenanceId());
            task.setMaintenance(maintenance);
        }

        return taskManutenzioneRepository.save(task);
    }
}
