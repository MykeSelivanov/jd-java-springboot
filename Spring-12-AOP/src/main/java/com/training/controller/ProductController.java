package com.training.controller;

import com.training.entity.Product;
import com.training.entity.ResponseWrapper;
import com.training.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){

       return ResponseEntity
               .ok(productService.getProduct(id));
    }

    @GetMapping
    public List<Product> getProducts(){

        logger.info("Before -> Controller:{} - Method:{} - Input Parameter :{}","ProductController", "getProducts()");

        List<Product> list = productService.getProducts();

        logger.info("After -> Controller:{} - Method:{} - Output Parameters:{}","ProductController","getProducts",list);

        return list;
    }


    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product){

        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version","Training.v1")
                .header("Operation","Create")
                .body(set);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id){

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Training.v1");
        responseHttpHeaders.set("Operation", "Delete");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list, responseHttpHeaders, HttpStatus.OK);
    }

    // MultiValueMap
    @PutMapping(value = "/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Version","Training.v1");
        map.add("Operation","Update");

        List<Product> list = productService.updateProduct(id, product);

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved", productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("product successfully deleted", productService.delete(id)));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseWrapper("product successfully deleted", productService.delete(id)));
    }

}
