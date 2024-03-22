package it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Review;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;

import it.epiocde.progettoCantiereNavale.repositories.Clienti.ReviewRepo;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.ServiceOfferingRepo;
import it.epiocde.progettoCantiereNavale.repositories.User.CustomerRepo;

import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.ReviewRequest;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ServiceOfferingRepo serviceOfferingRepository;

    public Page<Review> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Review getReviewById(Long id) throws NotFoundException {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review not found with ID: " + id));
    }

    public Review createReview(ReviewRequest reviewRequest) throws NotFoundException {
        Review review = new Review();
        review.setTestoRecensione(reviewRequest.getTestoRecensione());
        review.setValutazione(reviewRequest.getValutazione());
        review.setDataRecensione(new Date());

        Customer customer = customerRepository.findById(reviewRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + reviewRequest.getCustomerId()));
        review.setCustomer(customer);

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(reviewRequest.getServiceOfferingId())
                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + reviewRequest.getServiceOfferingId()));
        review.setServiceOffering(serviceOffering);

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) throws NotFoundException {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
    }

    public Review updateReview(Long id, ReviewRequest reviewRequest) throws NotFoundException {
        Review review = getReviewById(id);
        review.setTestoRecensione(reviewRequest.getTestoRecensione());
        review.setValutazione(reviewRequest.getValutazione());

        Customer customer = customerRepository.findById(reviewRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + reviewRequest.getCustomerId()));
        review.setCustomer(customer);

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(reviewRequest.getServiceOfferingId())
                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + reviewRequest.getServiceOfferingId()));
        review.setServiceOffering(serviceOffering);

        return reviewRepository.save(review);
    }
}
