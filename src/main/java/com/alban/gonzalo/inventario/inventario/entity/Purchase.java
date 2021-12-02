package com.alban.gonzalo.inventario.inventario.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase", nullable = false, unique = true)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "code", length = 50)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<PurchaseStoreProduct> purchaseStoreProducts;

    public Purchase() {
    }

    public Purchase(LocalDateTime date, String code, Client client) {
        this.date = date;
        this.code = code;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<PurchaseStoreProduct> getPurchaseStoreProducts() {
        return purchaseStoreProducts;
    }

    public void setPurchaseStoreProducts(Set<PurchaseStoreProduct> purchaseStoreProducts) {
        this.purchaseStoreProducts = purchaseStoreProducts;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", code='" + code + '\'' +
                ", client=" + client +
                ", purchaseStoreProducts=" + purchaseStoreProducts +
                '}';
    }
}
