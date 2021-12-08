package com.schambeck.webmvc.repository;

import com.schambeck.webmvc.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
