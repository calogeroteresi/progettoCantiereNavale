package it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Pagamento;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Finanza.PagamentoRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.PagamentoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepo pagamentoRepository;

    public Pagamento getPagamentoById(Long id) throws NotFoundException {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if (!optionalPagamento.isPresent()) {
            throw new NotFoundException("Pagamento not found with ID: " + id);
        }
        return optionalPagamento.get();
    }

    public List<Pagamento> getAllPagamenti() {
        return pagamentoRepository.findAll();
    }

    public Pagamento createPagamento(PagamentoRequest pagamentoRequest) {
        Pagamento pagamento = new Pagamento();
        mapPagamentoRequestToEntity(pagamentoRequest, pagamento);
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento updatePagamento(Long id, PagamentoRequest pagamentoRequest) throws NotFoundException {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if (!optionalPagamento.isPresent()) {
            throw new NotFoundException("Pagamento not found with ID: " + id);
        }
        Pagamento pagamento = optionalPagamento.get();
        mapPagamentoRequestToEntity(pagamentoRequest, pagamento);
        return pagamentoRepository.save(pagamento);
    }

    public void deletePagamento(Long id) throws NotFoundException {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if (!optionalPagamento.isPresent()) {
            throw new NotFoundException("Pagamento not found with ID: " + id);
        }
        pagamentoRepository.deleteById(id);
    }

    private void mapPagamentoRequestToEntity(PagamentoRequest request, Pagamento entity) {
        entity.setMetodoPagamento(request.getMetodoPagamento());
        entity.setStatoPagamento(request.getStatoPagamento());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setImportoPagato(request.getImportoPagato());
    }

    public List<Pagamento> getPagamentiByFatturaCliente(FatturaCliente fatturaCliente) {
        return pagamentoRepository.findByFatturaCliente(fatturaCliente);
    }

    public List<Pagamento> getPagamentiByFatturaFornitore(FatturaFornitore fatturaFornitore) {
        return pagamentoRepository.findByFatturaFornitore(fatturaFornitore);
    }
}
