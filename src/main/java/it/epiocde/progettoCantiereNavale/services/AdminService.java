package it.epiocde.progettoCantiereNavale.services;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import it.epiocde.progettoCantiereNavale.repositories.User.AdminRepo;
import it.epiocde.progettoCantiereNavale.requests.User.AdminRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepo adminRepository;

    @Autowired
    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(@Valid AdminRequest adminRequest) {
        Admin admin = mapRequestToEntity(adminRequest);
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Metodo per mappare la richiesta di admin a un'entità Admin
    private Admin mapRequestToEntity(AdminRequest adminRequest) {
        Admin admin = new Admin();
        // Mappa i campi comuni degli utenti
        // admin.setUsername(adminRequest.getUsername());
        // admin.setPassword(adminRequest.getPassword());
        // admin.setEmail(adminRequest.getEmail());
        // Etc...

        // Imposta il ruolo admin e gli ID dell'AdminEmployee e degli Employee
        admin.setRuoloAdmin(adminRequest.getRuoloAdmin());
        // Assicurati di gestire correttamente le associazioni con AdminEmployee e Employee
        // admin.setAdminEmployeeId(adminRequest.getAdminEmployeeId());
        // admin.setEmployeeIds(adminRequest.getEmployeeIds());
        return admin;
    }
}
