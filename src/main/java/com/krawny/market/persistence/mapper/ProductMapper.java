package com.krawny.market.persistence.mapper;

import com.krawny.market.domain.DomainProduct;
import com.krawny.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "priceSale", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    DomainProduct toDomainProduct(Product product);
    List<DomainProduct> toDomainProducts(List<Product> productList);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(DomainProduct domainProduct);
}
