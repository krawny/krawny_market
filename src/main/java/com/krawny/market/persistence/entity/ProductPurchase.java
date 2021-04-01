package com.krawny.market.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="id_compra", insertable = false,updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false,updatable = false)
    private Product product;

}
