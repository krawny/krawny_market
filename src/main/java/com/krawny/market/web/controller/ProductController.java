package com.krawny.market.web.controller;

import com.krawny.market.domain.DomainProduct;
import com.krawny.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<DomainProduct> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DomainProduct> getProduct(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<DomainProduct>> getByIdCategory(@PathVariable("id") Integer categoryId) {
        return productService.getByIdCategory(categoryId);
    }

    @PostMapping()
    public DomainProduct save(@RequestBody DomainProduct domainProduct) {

        return productService.save(domainProduct);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer productId) {
        return productService.delete(productId);
    }

    @PutMapping("/{id}")
    public DomainProduct update(@PathVariable("id") Integer productId, @RequestBody DomainProduct domainProduct) {
        return productService.update(productId, domainProduct);
    }

}
