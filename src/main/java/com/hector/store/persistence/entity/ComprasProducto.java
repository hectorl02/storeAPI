package com.hector.store.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name="compras_producto")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;

    private double total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="id_compra",insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name="id_producto",insertable = false, updatable = false)
    private Producto producto;


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
