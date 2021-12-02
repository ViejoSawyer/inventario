package com.alban.gonzalo.inventario.inventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store", nullable = false, unique = true)
    private Long id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 150)
    private String name;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<ProductStore> productStores;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<PurchaseStoreProduct> purchaseStoreProducts;

    public Store() {
    }

    public Store(String code, String name) {
        this.code = code;
        this.name = name;
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
        return "Store{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", productStores=" + productStores +
                ", purchaseStoreProducts=" + purchaseStoreProducts +
                '}';
    }
}
