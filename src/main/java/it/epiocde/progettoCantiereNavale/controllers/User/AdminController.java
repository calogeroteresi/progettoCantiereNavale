package it.epiocde.progettoCantiereNavale.controllers.User;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import it.epiocde.progettoCantiereNavale.requests.User.AdminRequest;
import it.epiocde.progettoCantiereNavale.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody AdminRequest adminRequest) {
        Admin createdAdmin = adminService.createAdmin(adminRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
