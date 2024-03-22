package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.OrderCustomerRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti.OrderCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-customers")
public class OrderCustomerController {

    @Autowired
    private OrderCustomerService orderCustomerService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createOrderCustomer(@RequestBody @Validated OrderCustomerRequest orderCustomerRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        OrderCustomer createdOrder = orderCustomerService.createOrder(orderCustomerRequest);
        return DefaultResponse.noMessage(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getOrderCustomerById(@PathVariable Long id) throws NotFoundException {
        OrderCustomer orderCustomer = orderCustomerService.getOrderById(id);
        return DefaultResponse.noMessage(orderCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteOrderCustomer(@PathVariable Long id) throws NotFoundException {
        orderCustomerService.deleteOrder(id);
        String message = "Order Customer with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateOrderCustomer(@PathVariable Long id, @RequestBody @Validated OrderCustomerRequest orderCustomerRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        OrderCustomer updatedOrder = orderCustomerService.updateOrder(id, orderCustomerRequest);
        return DefaultResponse.noMessage(updatedOrder, HttpStatus.OK);
    }
}
