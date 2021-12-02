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
@Table(name = "purchase_store_product")
public class PurchaseStoreProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_store_product", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_purchase")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_store")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public PurchaseStoreProduct() {
    }

    public PurchaseStoreProduct(Purchase purchase, Store store, Product product) {
        this.purchase = purchase;
        this.store = store;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "PurchaseStoreProduct{" +
                "id=" + id +
                ", purchase=" + purchase +
                ", store=" + store +
                ", product=" + product +
                '}';
    }
}
