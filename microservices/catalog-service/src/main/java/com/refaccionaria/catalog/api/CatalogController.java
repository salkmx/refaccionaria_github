package com.refaccionaria.catalog.api;

import com.refaccionaria.catalog.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class CatalogController {

    private static final List<Product> PRODUCTS = List.of(
            new Product(1L, "ACE-001", "Balata Delantera", new BigDecimal("890.00"), 15),
            new Product(2L, "FILT-015", "Filtro de Aceite", new BigDecimal("155.00"), 65),
            new Product(3L, "BUJ-031", "Bujía de Iridio", new BigDecimal("220.00"), 40)
    );

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(PRODUCTS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return PRODUCTS.stream()
                .filter(product -> product.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
