package com.krawny.market.domain.repository;

import com.krawny.market.domain.DomainProduct;

import java.util.List;
import java.util.Optional;

public interface DomainProductRepository {

    List<DomainProduct> getAll();
    Optional<List<DomainProduct>> getByIdCategory(Integer categoryId);
    Optional<List<DomainProduct>> getLowStock(Integer quantity);
    Optional<DomainProduct> getProduct(Integer productId);
    DomainProduct save(DomainProduct domainProduct);
    void delete(Integer productId);
}
