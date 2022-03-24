package com.hector.store.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name="compras_producto")
public class BuysProduct {

    @EmbeddedId
    private BuysProductPK id;

    @Column(name="cantidad")
    private Integer quantity;

    private double total;

    @Column(name="estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name="id_compra",insertable = false, updatable = false)
    private Buy buy;

    public BuysProductPK getId() {
        return id;
    }

    public void setId(BuysProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
