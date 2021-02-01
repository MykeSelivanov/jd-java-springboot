package com.training.implementation;

import com.training.model.Address;
import com.training.repository.AddressRepository;
import com.training.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;
    RestTemplate restTemplate;

    public AddressServiceImpl(AddressRepository addressRepository, RestTemplate restTemplate) {
        this.addressRepository = addressRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Address getAddress(Long id) {
        Address addressEntity = addressRepository.findById(id).get();
        addressEntity.setCurrentTemperature(consumeTemp(addressEntity.getCity()));
        return addressEntity;
    }

    @Override
    public List<Address> getAddresses() {
        List<Address> addressList = addressRepository.findAll();
        addressList.stream().forEach(address -> address.setCurrentTemperature(consumeTemp(address.getCity())));
        return addressList;
    }

    @Override
    public List<Address> deleteAddress(Long id) {
        addressRepository.deleteById(id);
        List<Address> addressList = addressRepository.findAll();
        addressList.stream().forEach(address -> address.setCurrentTemperature(consumeTemp(address.getCity())));
        return addressList;
    }

    @Override
    public Address updateAddress(Long id, Address address) throws Exception {
        Optional<Address> addressEntity = addressRepository.findById(id);
        if (!addressEntity.isPresent()) {
            throw new Exception("Address does not exist");
        }
        address.setId(addressEntity.get().getId());
        address.setCurrentTemperature(consumeTemp(address.getCity()));
        return addressRepository.save(address);
    }

    @Override
    public List<Address> createAddress(Address address) {
        addressRepository.save(address);
        List<Address> addressList = addressRepository.findAll();
        addressList.stream().forEach(addressEntity -> addressEntity.setCurrentTemperature(consumeTemp(addressEntity.getCity())));
        return addressList;
    }

    public Integer consumeTemp(String city){
        String BASE_URL = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";
        String uri = BASE_URL + city;

        Object currentWeather = restTemplate.getForObject(uri, Object.class);

        Map<String,Object> getWeather = (Map<String,Object>) currentWeather;
        Map<String,Object> getTemperature = (Map<String,Object>) getWeather.get("current");

        return Integer.parseInt(getTemperature.get("temperature").toString());
    }

}
