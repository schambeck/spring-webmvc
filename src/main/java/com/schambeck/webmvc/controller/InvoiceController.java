package com.schambeck.webmvc.controller;

import com.schambeck.webmvc.domain.Invoice;
import com.schambeck.webmvc.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Validated
@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
class InvoiceController {

    private final InvoiceService service;

    @ResponseStatus(OK)
    @GetMapping
    List<Invoice> findAll() {
        return service.findAll();
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    Invoice findById(@PathVariable("id") @Positive Long id) {
        return service.findById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Invoice create(@RequestBody @Valid Invoice invoice) {
        return service.create(invoice);
    }

    @ResponseStatus(CREATED)
    @PutMapping
    Invoice upsert(@RequestBody @Valid Invoice invoice) {
        return service.create(invoice);
    }

    @ResponseStatus(OK)
    @PutMapping("/{id}")
    Invoice update(@PathVariable("id") @Positive Long id, @RequestBody @Valid Invoice invoice) {
        return service.update(id, invoice);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }

}
