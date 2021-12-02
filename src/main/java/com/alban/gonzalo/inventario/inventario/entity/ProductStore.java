package com.alban.gonzalo.inventario.inventario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_store")
public class ProductStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_store", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_store")
    @JsonBackReference
    private Store store;

    public ProductStore() {
    }

    public ProductStore(Product product, Store store) {
        this.product = product;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "ProductStore{" +
                "id=" + id +
                ", product=" + product +
                ", store=" + store +
                '}';
    }
}
