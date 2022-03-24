package com.hector.store.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="categoria")
public class Category {

    @Column(name="id_categoria")
    private Integer idCategory;

    @Column(name="descripcion")
    private String description;

    @Column(name="estado")
    private Boolean state;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
