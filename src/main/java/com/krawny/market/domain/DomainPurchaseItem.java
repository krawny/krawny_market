package com.krawny.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DomainPurchaseItem {
    private Integer productId;
    private Integer quantity;
    private BigDecimal total;
    private boolean active;

}
