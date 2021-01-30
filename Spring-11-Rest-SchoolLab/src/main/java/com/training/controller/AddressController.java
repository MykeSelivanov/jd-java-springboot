package com.training.controller;

import com.training.model.Address;
import com.training.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddresses());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(addressService.getAddress(id));
    }



}
