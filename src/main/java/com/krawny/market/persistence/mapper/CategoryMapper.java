package com.krawny.market.persistence.mapper;

import com.krawny.market.domain.DomainCategory;
import com.krawny.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            //@Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "active"),
    })
    DomainCategory toDomainCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productList", ignore = true)
    Category toCategory(DomainCategory domainCategory);
}
