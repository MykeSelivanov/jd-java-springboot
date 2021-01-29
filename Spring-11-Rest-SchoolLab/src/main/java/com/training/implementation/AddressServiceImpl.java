package com.training.implementation;

import com.training.entity.Address;
import com.training.repository.AddressRepository;
import com.training.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> deleteAddress(Long id) {
        return null;
    }

    @Override
    public List<Address> updateAddress(Long id, Address address) {
        Address addressEntity = addressRepository.findById(id).get();
        address.setId(addressEntity.getId());
        addressRepository.save(address);
        return addressRepository.findAll();
    }

    @Override
    public List<Address> createAddress(Address address) {
        return null;
    }
}
