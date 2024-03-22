package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Review;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.ReviewRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createReview(@RequestBody @Validated ReviewRequest reviewRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Review createdReview = reviewService.createReview(reviewRequest);
        return DefaultResponse.noMessage(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getReviewById(@PathVariable Long id) throws NotFoundException {
        Review review = reviewService.getReviewById(id);
        return DefaultResponse.noMessage(review, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteReview(@PathVariable Long id) throws NotFoundException {
        reviewService.deleteReview(id);
        String message = "Review with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateReview(@PathVariable Long id, @RequestBody @Validated ReviewRequest reviewRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Review updatedReview = reviewService.updateReview(id, reviewRequest);
        return DefaultResponse.noMessage(updatedReview, HttpStatus.OK);
    }
}
