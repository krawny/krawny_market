package com.krawny.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainCategory {

    private int categoryId;
    private String description;
    private boolean active;
}
