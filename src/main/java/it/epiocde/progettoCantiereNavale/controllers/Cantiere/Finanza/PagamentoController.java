package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Pagamento;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.PagamentoRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllPagamenti() {
        List<Pagamento> pagamenti = pagamentoService.getAllPagamenti();
        return DefaultResponse.noMessage(pagamenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getPagamentoById(@PathVariable Long id) throws NotFoundException {
        Pagamento pagamento = pagamentoService.getPagamentoById(id);
        return DefaultResponse.noMessage(pagamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createPagamento(@RequestBody @Validated PagamentoRequest pagamentoRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Pagamento createdPagamento = pagamentoService.createPagamento(pagamentoRequest);
        return DefaultResponse.noMessage(createdPagamento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deletePagamento(@PathVariable Long id) throws NotFoundException {
        pagamentoService.deletePagamento(id);
        String message = "Pagamento with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updatePagamento(@PathVariable Long id, @RequestBody @Validated PagamentoRequest pagamentoRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Pagamento updatedPagamento = pagamentoService.updatePagamento(id, pagamentoRequest);
        return DefaultResponse.noMessage(updatedPagamento, HttpStatus.OK);
    }
}
