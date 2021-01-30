package com.training.controller;

import com.training.model.Address;
import com.training.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {
        return addressService.updateAddress(id, address);
    }



}
