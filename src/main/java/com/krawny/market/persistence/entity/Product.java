package com.krawny.market.persistence.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProduct;

    @Column(name="nombre")
    private String name;

    @NotNull
    @Column(name="id_categoria")
    private Integer idCategory;

    @Column(name="codigo_barras")
    private String barcode;

    @Column(name="precio_venta")
    private BigDecimal priceSale;
    // MonetaryAmountFormatter--> Validar

    @NotNull
    @Column(name="cantidad_stock")
    private Integer stockQuantity;

    @Column(name="estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false,updatable = false)
    private Category category;
}
