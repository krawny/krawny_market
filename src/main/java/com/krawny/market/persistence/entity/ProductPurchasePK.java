package com.krawny.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductPurchasePK implements Serializable {

    @Column(name="id_compra")
    private Integer idPurchase;

    @Column(name="id_producto")
    private Integer idProduct;
}
