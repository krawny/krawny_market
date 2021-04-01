package com.krawny.market.persistence.crud;

import com.krawny.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory);
    Optional<List<Product>> findByStockQuantityLessThanAndStatus(Integer stockQuantity, Boolean status);
}
