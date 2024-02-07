DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (
                                id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                                number_invoice VARCHAR(50),
                                description VARCHAR(250),
                                customer_id BIGINT,
                                create_at DATE,
                                state VARCHAR(100)
);


DROP TABLE IF EXISTS invoice_items;

CREATE TABLE invoice_items (
                              id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                              invoice_id BIGINT,
                              product_id BIGINT,
                              quantity DOUBLE,
                              price DOUBLE,
                              FOREIGN key(invoice_id) REFERENCES invoices(id)
);