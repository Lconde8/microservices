package com.shopping.shopping.Repository;

import com.shopping.shopping.Entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
}
