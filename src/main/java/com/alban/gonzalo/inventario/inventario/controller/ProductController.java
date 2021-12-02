package com.alban.gonzalo.inventario.inventario.controller;

import com.alban.gonzalo.inventario.inventario.entity.Product;
import com.alban.gonzalo.inventario.inventario.repository.ProductRepository;
import com.alban.gonzalo.inventario.inventario.service.ProductService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/data")
    MappingJacksonValue all() {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.serializeAll();
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("productFilter", simpleBeanPropertyFilter);

        List<Product> products = productRepository.findAll();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(products);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/")
    MappingJacksonValue allProductData() {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "code", "name");
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("productFilter", simpleBeanPropertyFilter);

        List<Product> products = productRepository.findAll();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(products);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productService.update(newProduct, id);
    }

}
