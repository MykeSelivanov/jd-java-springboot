package com.training.controller;

import com.training.entity.Product;
import com.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") Long id){

        return productService.getProduct(id);
    }

    @GetMapping                     // if you don't put method, by default it's GET
    public List<Product> getProducts(){

        return productService.getProducts();
    }

    //CREATE PRODUCT
    @PostMapping
    public List<Product> createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

    //DELETE PRODUCT
    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id){

        return productService.delete(id);
    }

    //UPDATE PRODUCT
    @PutMapping(value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        return productService.updateProduct(id, product);
    }
}
