package com.krawny.market.persistence.mapper;

import com.krawny.market.domain.DomainPurchaseItem;
import com.krawny.market.persistence.entity.ProductPurchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring" , uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings ({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    DomainPurchaseItem toPurchaseItem(ProductPurchase productPurchase);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    ProductPurchase toProductPurchase(DomainPurchaseItem domainPurchaseItem);
}
