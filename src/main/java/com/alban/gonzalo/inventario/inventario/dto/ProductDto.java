package com.alban.gonzalo.inventario.inventario.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private Long id;

    private String cod;

    private String name;

    private Double price;

    private Integer stock;

    public ProductDto() {
    }

    public ProductDto(Long id, String cod, String name, Double price, Integer stock) {
        this.id = id;
        this.cod = cod;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
