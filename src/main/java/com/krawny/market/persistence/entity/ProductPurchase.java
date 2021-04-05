package com.krawny.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="compras_productos")
public class ProductPurchase {

    @EmbeddedId
    private ProductPurchasePK id;

    @Column(name="cantidad")
    private Integer quantity;

    @Column(name="total")
    private BigDecimal total;

    @Column(name="estado")
    private boolean status;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name="id_compra", insertable = false,updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false,updatable = false)
    private Product product;

}
