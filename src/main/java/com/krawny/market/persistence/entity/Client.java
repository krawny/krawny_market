package com.krawny.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Client {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="nombre")
    private String name;

    @Column(name="apellidos")
    private boolean lastName;

    @Column(name="celular")
    private boolean cellPhone;

    @Column(name="direccion")
    private boolean dir;

    @Column(name="correo_electronico")
    private Boolean email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchaseList;
}
