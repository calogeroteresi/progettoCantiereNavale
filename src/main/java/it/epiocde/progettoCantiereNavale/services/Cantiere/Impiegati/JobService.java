package it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Job;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Impiegati.JobRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepository;

    public Job getJobById(Long id) throws NotFoundException {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isEmpty()) {
            throw new NotFoundException("Job not found with ID: " + id);
        }
        return optionalJob.get();
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(JobRequest jobRequest) {
        Job job = new Job();
        mapJobRequestToEntity(jobRequest, job);
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, JobRequest jobRequest) throws NotFoundException {
        Job job = getJobById(id);
        mapJobRequestToEntity(jobRequest, job);
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) throws NotFoundException {
        Job job = getJobById(id);
        jobRepository.delete(job);
    }

    private void mapJobRequestToEntity(JobRequest request, Job entity) {
        entity.setTitolo(request.getTitolo());
        entity.setDescrizione(request.getDescrizione());
        entity.setDataInizio(request.getDataInizio());
        entity.setDataFine(request.getDataFine());
        entity.setStato(request.getStato());
        // Aggiungi altre associazioni qui se necessario
    }
}
