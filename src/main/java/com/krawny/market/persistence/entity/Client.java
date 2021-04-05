package com.krawny.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="clientes")
public class Client {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="nombre")
    private String name;

    @Column(name="apellidos")
    private String lastName;

    @Column(name="celular")
    private Long cellPhone;

    @Column(name="direccion")
    private String dir;

    @Column(name="correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchaseList;
}
