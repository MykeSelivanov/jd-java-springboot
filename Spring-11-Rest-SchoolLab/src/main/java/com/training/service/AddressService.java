package com.training.service;

import com.training.model.Address;

import java.util.List;

public interface AddressService {

    Address getAddress(Long id);
    List<Address> getAddresses();
    List<Address> deleteAddress(Long id);
    Address updateAddress(Long id, Address address) throws Exception;
    List<Address> createAddress(Address address);

}
