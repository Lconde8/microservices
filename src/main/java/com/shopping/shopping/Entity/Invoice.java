package com.shopping.shopping.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;
    private String description;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "create_at")
    private Date createAt;

    @Valid
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;

    private String state;

    public Invoice(){
        items = new ArrayList<>();
    }


    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    
}
