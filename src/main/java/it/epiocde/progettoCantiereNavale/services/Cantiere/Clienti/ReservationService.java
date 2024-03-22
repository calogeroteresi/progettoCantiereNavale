package it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Reservation;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.DockAvailability;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.repositories.Clienti.ReservationRepo;
import it.epiocde.progettoCantiereNavale.repositories.Dock.DockAvailabilityRepo;
import it.epiocde.progettoCantiereNavale.repositories.User.CustomerRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.ReservationRequest;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private DockAvailabilityRepo dockAvailabilityRepository;

    public Page<Reservation> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    public Reservation getReservationById(Long id) throws NotFoundException {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found with ID: " + id));
    }

    public Reservation createReservation(ReservationRequest reservationRequest) throws NotFoundException {
        Reservation reservation = new Reservation();
        reservation.setDataPrenotazione(new Date());
        reservation.setDataInizio(reservationRequest.getDataInizio());
        reservation.setDataFine(reservationRequest.getDataFine());
        reservation.setConfermata(reservationRequest.isConfermata());

        Customer customer = customerRepository.findById(reservationRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + reservationRequest.getCustomerId()));
        reservation.setCustomer(customer);

        DockAvailability dockAvailability = dockAvailabilityRepository.findById(reservationRequest.getDockAvailabilityId())
                .orElseThrow(() -> new NotFoundException("Dock Availability not found with ID: " + reservationRequest.getDockAvailabilityId()));
        reservation.setDockAvailability(dockAvailability);

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) throws NotFoundException {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }

    public Reservation updateReservation(Long id, ReservationRequest reservationRequest) throws NotFoundException {
        Reservation reservation = getReservationById(id);
        reservation.setDataInizio(reservationRequest.getDataInizio());
        reservation.setDataFine(reservationRequest.getDataFine());
        reservation.setConfermata(reservationRequest.isConfermata());

        Customer customer = customerRepository.findById(reservationRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + reservationRequest.getCustomerId()));
        reservation.setCustomer(customer);

        DockAvailability dockAvailability = dockAvailabilityRepository.findById(reservationRequest.getDockAvailabilityId())
                .orElseThrow(() -> new NotFoundException("Dock Availability not found with ID: " + reservationRequest.getDockAvailabilityId()));
        reservation.setDockAvailability(dockAvailability);

        return reservationRepository.save(reservation);
    }
}
