package com.alban.gonzalo.inventario.inventario.service;

import com.alban.gonzalo.inventario.inventario.dto.ProductsDto;
import com.alban.gonzalo.inventario.inventario.entity.Product;
import com.alban.gonzalo.inventario.inventario.repository.ProductRepository;
import com.alban.gonzalo.inventario.inventario.util.CustomErrorType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void save() throws JsonProcessingException {
        final String uri = "https://mocki.io/v1/a26648ad-7acf-4f34-8886-932bccc219c0";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        ProductsDto productsDto = objectMapper.readValue(result, ProductsDto.class);

        List<Product> products = new ArrayList<>();
        productsDto.getProds().stream().forEach(prod -> {
            Product product = new Product();
            product.setCode(prod.getCod());
            product.setName(prod.getName());
            product.setPrice(prod.getPrice());
            product.setStock(prod.getStock());
            products.add(product);
        });

        productRepository.saveAll(products);
    }

    @Transactional
    @Override
    public ResponseEntity<?> update(Product newProduct, Long id) {

        return productRepository.findById(id)
            .map(prod -> {
                if (newProduct.getStock() > 0) {
                    prod.setCode(newProduct.getCode());
                    prod.setName(newProduct.getName());
                    prod.setPrice(newProduct.getPrice());
                    prod.setStock(newProduct.getStock());
                    return new ResponseEntity<Product>(productRepository.save(prod), HttpStatus.OK);
                }
                return new ResponseEntity(new CustomErrorType("El stock no puede ser menor o igual a 0"), HttpStatus.BAD_REQUEST);
            }).orElse(new ResponseEntity(new CustomErrorType("Producto con código " + id + " no encontrado"), HttpStatus.BAD_REQUEST));
    }
}
