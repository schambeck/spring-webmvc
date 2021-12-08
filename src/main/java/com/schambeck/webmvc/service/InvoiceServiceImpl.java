package com.schambeck.webmvc.service;

import com.schambeck.webmvc.base.exception.NotFoundException;
import com.schambeck.webmvc.domain.Invoice;
import com.schambeck.webmvc.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    @Override
    public List<Invoice> findAll() {
        return repository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(format("Entity %d not found", id)));
    }

    @Override
    public Invoice create(Invoice invoice) {
        return repository.save(invoice.setAsNew());
    }

    @Override
    public Invoice update(Long id, Invoice invoice) {
        Invoice found = findById(id);
        return repository.save(found.toBuilder()
                .issued(invoice.getIssued())
                .total(invoice.getTotal()).build());
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException(format("Entity %d not found", id));
        }
    }

}
