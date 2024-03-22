package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.CustomerFeedbackRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti.CustomerFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-feedbacks")
public class CustomerFeedbackController {

    @Autowired
    private CustomerFeedbackService customerFeedbackService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createCustomerFeedback(@RequestBody @Validated CustomerFeedbackRequest feedbackRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        CustomerFeedback createdFeedback = customerFeedbackService.createCustomerFeedback(feedbackRequest);
        return DefaultResponse.noMessage(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getCustomerFeedbackById(@PathVariable Long id) throws NotFoundException {
        CustomerFeedback feedback = customerFeedbackService.getCustomerFeedbackById(id);
        return DefaultResponse.noMessage(feedback, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteCustomerFeedback(@PathVariable Long id) throws NotFoundException {
        customerFeedbackService.deleteCustomerFeedback(id);
        String message = "Customer Feedback with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateCustomerFeedback(@PathVariable Long id, @RequestBody @Validated CustomerFeedbackRequest feedbackRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        CustomerFeedback updatedFeedback = customerFeedbackService.updateCustomerFeedback(id, feedbackRequest);
        return DefaultResponse.noMessage(updatedFeedback, HttpStatus.OK);
    }
}
