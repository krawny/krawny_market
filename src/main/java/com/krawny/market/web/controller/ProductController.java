package com.krawny.market.web.controller;

import com.krawny.market.domain.DomainProduct;
import com.krawny.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<DomainProduct>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainProduct> getProduct(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<DomainProduct>> getByIdCategory(@PathVariable("id") Integer categoryId) {
        return productService.getByIdCategory(categoryId)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<DomainProduct> save(@RequestBody DomainProduct domainProduct) {
        return new ResponseEntity<>(productService.save(domainProduct), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<DomainProduct> update(@PathVariable("id") Integer productId, @RequestBody DomainProduct domainProduct) {
        return new ResponseEntity<>(productService.update(productId, domainProduct), HttpStatus.OK);
    }

}
