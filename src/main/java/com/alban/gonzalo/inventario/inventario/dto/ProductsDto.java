package com.alban.gonzalo.inventario.inventario.dto;

import java.io.Serializable;
import java.util.Set;

public class ProductsDto implements Serializable {

    private Set<ProductDto> prods;

    public ProductsDto() {
    }

    public ProductsDto(Set<ProductDto> prods) {
        this.prods = prods;
    }

    public Set<ProductDto> getProds() {
        return prods;
    }

    public void setProds(Set<ProductDto> prods) {
        this.prods = prods;
    }
}
