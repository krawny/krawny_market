package com.krawny.market.domain.service;

import com.krawny.market.domain.DomainProduct;
import com.krawny.market.domain.repository.DomainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private DomainProductRepository domainProductRepository;

    public List<DomainProduct> getAll() {
        return domainProductRepository.getAll();
    }

    public Optional<DomainProduct> getProduct(Integer productId) {
        return domainProductRepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByIdCategory(Integer categoryId) {
        return domainProductRepository.getByIdCategory(categoryId);
    }


    public DomainProduct save(DomainProduct domainProduct) {
        return domainProductRepository.save(domainProduct);
    }

    public boolean delete(Integer productId) {
        return getProduct(productId).map(product -> {
            domainProductRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    public DomainProduct update(Integer productId, DomainProduct domainProduct) {
        return domainProductRepository.getProduct(productId)
                .map(product -> {
                    product.setName(domainProduct.getName());
                    product.setPrice(domainProduct.getPrice());
                    product.setCategoryId(domainProduct.getCategoryId());
                    product.setStock(domainProduct.getStock());
                    product.setActive(domainProduct.isActive());

                    return domainProductRepository.save(product);
                }).orElseGet(() -> {
                    domainProduct.setProductId(productId);
                    return domainProductRepository.save(domainProduct);
                });
    }

}
