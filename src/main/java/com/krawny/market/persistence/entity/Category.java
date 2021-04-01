package com.krawny.market.persistence.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idCategory;

    @NotNull
    @Column(name="descripcion")
    private String description;

    @NotNull
    @Column(name="estado")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
