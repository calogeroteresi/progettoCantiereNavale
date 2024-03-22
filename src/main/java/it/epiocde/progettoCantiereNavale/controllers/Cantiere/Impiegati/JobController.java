package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Job;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.JobRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getJobById(@PathVariable Long id) throws NotFoundException {
        Job job = jobService.getJobById(id);
        return DefaultResponse.noMessage(job, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return DefaultResponse.noMessage(jobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createJob(@RequestBody @Validated JobRequest jobRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Job createdJob = jobService.createJob(jobRequest);
        return DefaultResponse.noMessage(createdJob, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateJob(@PathVariable Long id, @RequestBody @Validated JobRequest jobRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Job updatedJob = jobService.updateJob(id, jobRequest);
        return DefaultResponse.noMessage(updatedJob, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteJob(@PathVariable Long id) throws NotFoundException {
        jobService.deleteJob(id);
        String message = "Job with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
