package com.store.microservices.Repository;

import com.store.microservices.Entity.Category;
import com.store.microservices.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
