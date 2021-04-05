package com.krawny.market.persistence.mapper;

import com.krawny.market.domain.DomainPurchase;
import com.krawny.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "dateTime", target = "date"),
            @Mapping(source = "productPurchaseList", target = "items")
    })
    DomainPurchase toDomainPurchase(Purchase purchase);

    List<DomainPurchase> toDomainPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "client", ignore = true)
    })
    Purchase toPurchase(DomainPurchase domainPurchase);
}
