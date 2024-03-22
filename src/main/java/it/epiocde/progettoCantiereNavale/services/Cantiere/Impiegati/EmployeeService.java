package it.epiocde.progettoCantiereNavale.services.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Impiegati.EmployeeRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws NotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with ID: " + id));
    }

    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        mapEmployeeRequestToEntity(employeeRequest, employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest) throws NotFoundException {
        Employee employee = getEmployeeById(id);
        mapEmployeeRequestToEntity(employeeRequest, employee);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) throws NotFoundException {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private void mapEmployeeRequestToEntity(EmployeeRequest request, Employee entity) {
        entity.setNome(request.getNome());
        entity.setCognome(request.getCognome());
        entity.setRuolo(request.getRuolo());
        entity.setSettore(request.getSettore());
        entity.setDataAssunzione(request.getDataAssunzione());
        entity.setStipendio(request.getStipendio());
        // Puoi aggiungere il mapping per altri campi se necessario
    }
}
