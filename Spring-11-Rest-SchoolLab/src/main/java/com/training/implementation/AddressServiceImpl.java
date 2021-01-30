package com.training.implementation;

import com.training.model.Address;
import com.training.repository.AddressRepository;
import com.training.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        addressRepository.deleteById(id);
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Long id, Address address) throws Exception {
        Optional<Address> addressEntity = addressRepository.findById(id);
        if (!addressEntity.isPresent()) {
            throw new Exception("Address does not exist");
        }
        address.setId(addressEntity.get().getId());
        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        return addressRepository.save(address);
    }

    @Override
    public List<Address> createAddress(Address address) {
        addressRepository.save(address);
        return addressRepository.findAll();
    }
}
