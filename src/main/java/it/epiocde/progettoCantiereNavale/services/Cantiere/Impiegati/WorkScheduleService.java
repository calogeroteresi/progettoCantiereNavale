package it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.SchedaLavoroDipendenti;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Impiegati.SchedaLavoroRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.WorkScheduleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WorkScheduleService {

    @Autowired
    private SchedaLavoroRepo workScheduleRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    public SchedaLavoroDipendenti getWorkScheduleById(Long id) throws NotFoundException {
        Optional<SchedaLavoroDipendenti> optionalSchedule = workScheduleRepository.findById(id);
        if (optionalSchedule.isEmpty()) {
            throw new NotFoundException("Work schedule not found with ID: " + id);
        }
        return optionalSchedule.get();
    }

    public List<SchedaLavoroDipendenti> getAllWorkSchedules() {
        return workScheduleRepository.findAll();
    }

    public SchedaLavoroDipendenti createWorkSchedule(WorkScheduleRequest request) throws NotFoundException {
        SchedaLavoroDipendenti schedule = new SchedaLavoroDipendenti();
        mapWorkScheduleRequestToEntity(request, schedule);
        return workScheduleRepository.save(schedule);
    }

    public SchedaLavoroDipendenti updateWorkSchedule(Long id, WorkScheduleRequest request) throws NotFoundException {
        SchedaLavoroDipendenti schedule = getWorkScheduleById(id);
        mapWorkScheduleRequestToEntity(request, schedule);
        return workScheduleRepository.save(schedule);
    }

    public void deleteWorkSchedule(Long id) throws NotFoundException {
        SchedaLavoroDipendenti schedule = getWorkScheduleById(id);
        workScheduleRepository.delete(schedule);
    }

    private void mapWorkScheduleRequestToEntity(WorkScheduleRequest request, SchedaLavoroDipendenti entity) throws NotFoundException {
        entity.setDataLavoro(request.getDataLavoro());
        entity.setAttivita(request.getAttivita());
        entity.setOreLavorate(request.getOreLavorate());
        entity.setJob(jobService.getJobById(request.getJobId()));

        Set<Employee> employees = new HashSet<>();
        for (Long employeeId : request.getDipendentiIds()) {
            employees.add(employeeService.getEmployeeById(employeeId));
        }
        entity.setDipendenti(employees);
    }
}
