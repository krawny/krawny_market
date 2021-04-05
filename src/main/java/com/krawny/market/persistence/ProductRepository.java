package com.krawny.market.persistence;

import com.krawny.market.domain.DomainProduct;
import com.krawny.market.domain.repository.DomainProductRepository;
import com.krawny.market.persistence.crud.ProductCrudRepository;
import com.krawny.market.persistence.entity.Product;
import com.krawny.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements DomainProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<DomainProduct> getAll() {
        List<Product> productList = (List<Product>) productCrudRepository.findAll();
        return productMapper.toDomainProducts(productList);
    }

    @Override
    public Optional<List<DomainProduct>> getByIdCategory(Integer idCategory) {
        List<Product> productList = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(productMapper.toDomainProducts(productList));
    }

    @Override
    public Optional<List<DomainProduct>> getLowStock(Integer quantity) {
        Optional<List<Product>> productList = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return productList.map(pList -> productMapper.toDomainProducts(pList));
    }

    @Override
    public Optional<DomainProduct> getProduct(Integer idProduct) {
        return productCrudRepository.findById(idProduct)
                .map(product -> productMapper.toDomainProduct(product));
    }

    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product = productMapper.toProduct(domainProduct);
        return productMapper.toDomainProduct(productCrudRepository.save(product));

    }

    @Override
    public void delete(Integer idProduct) {
        productCrudRepository.deleteById(idProduct);
    }

}
