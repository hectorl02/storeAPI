package com.hector.store.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String firstNameClient;

    @Column(name="apellidos")
    private String lastnameClient;

    @Column(name="celular")
    private long cellPhone;

    @Column(name="direccion")
    private String address;

    @Column(name="correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Buy> buys;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getLastnameClient() {
        return lastnameClient;
    }

    public void setLastnameClient(String lastnameClient) {
        this.lastnameClient = lastnameClient;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
