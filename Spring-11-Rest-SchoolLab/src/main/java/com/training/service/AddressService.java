package com.training.service;

import com.training.entity.Address;

import java.util.List;

public interface AddressService {

    Address getAddress(Long id);
    List<Address> getAddresses();
    List<Address> deleteAddress(Long id);
    List<Address> updateAddress(Long id, Address address);
    List<Address> createAddress(Address address);

}
