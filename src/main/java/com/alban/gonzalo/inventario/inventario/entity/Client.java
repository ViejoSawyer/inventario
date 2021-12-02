package com.alban.gonzalo.inventario.inventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "document", length = 10, nullable = false)
    private String document;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Purchase> purchases;

    public Client() {
    }

    public Client(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", purchases=" + purchases +
                '}';
    }
}
