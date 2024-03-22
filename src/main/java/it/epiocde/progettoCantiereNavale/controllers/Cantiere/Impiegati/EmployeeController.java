package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.EmployeeRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getEmployeeById(@PathVariable Long id) throws NotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return DefaultResponse.noMessage(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return DefaultResponse.noMessage(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createEmployee(@RequestBody @Validated EmployeeRequest employeeRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Employee createdEmployee = employeeService.createEmployee(employeeRequest);
        return DefaultResponse.noMessage(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateEmployee(@PathVariable Long id, @RequestBody @Validated EmployeeRequest employeeRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return DefaultResponse.noMessage(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteEmployee(@PathVariable Long id) throws NotFoundException {
        employeeService.deleteEmployee(id);
        String message = "Employee with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
