package com.alban.gonzalo.inventario.inventario.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Set;


@Entity
@Table(name = "product")
@JsonFilter("productFilter")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false, unique = true)
    private Long id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ProductStore> productStores;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<PurchaseStoreProduct> purchaseStoreProducts;

    public Product() {
    }

    public Product(String code, String name, Double price, Integer stock) {
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Set<ProductStore> getProductStores() {
        return productStores;
    }

    public void setProductStores(Set<ProductStore> productStores) {
        this.productStores = productStores;
    }

    public Set<PurchaseStoreProduct> getPurchaseStoreProducts() {
        return purchaseStoreProducts;
    }

    public void setPurchaseStoreProducts(Set<PurchaseStoreProduct> purchaseStoreProducts) {
        this.purchaseStoreProducts = purchaseStoreProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", productStores=" + productStores +
                '}';
    }
}
