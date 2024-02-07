package com.store.microservices;

import com.store.microservices.Entity.Category;
import com.store.microservices.Entity.Product;
import com.store.microservices.Repository.ProductRepository;
import com.store.microservices.Service.ProductService;
import com.store.microservices.Service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductServicesMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Product shoes = Product.builder()
                .id(2L)
                .name("shoes")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("20.0"))
                .stock(Double.parseDouble("8"))
                .build();

        Mockito.when(productRepository.findAll())
                        .thenReturn(List.of(computer, shoes));

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenInvalidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(2L);
        org.junit.jupiter.api.Assertions.assertNull(found);
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }

    @Test
    public void whenValidProduct_ThenReturnListProduct(){
        List<Product> found = productService.listAllProduct();
        Assertions.assertThat(found.size()).isEqualTo(2);
    }
}
