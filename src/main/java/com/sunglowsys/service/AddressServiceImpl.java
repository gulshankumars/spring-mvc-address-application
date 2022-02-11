package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{


    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address createAddrerss(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(@RequestBody Address address, Integer id) {
        Address address1 = addressRepository.getById(id);
        if (address.getAddressLine1() != null){
            address1.setAddressLine1(address.getAddressLine1());
        }
        if (address.getAddressLine2() != null){
            address1.setAddressLine2(address.getAddressLine2());
        }
        if (address.getCity() != null){
            address1.setCity(address.getCity());
        }
        if (address.getState() != null){
            address1.setState(address.getState());
        }
        if (address.getCountry() != null){
            address1.setCountry(address.getCountry());
        }
        if (address.getZipcode() != null){
            address1.setZipcode(address.getZipcode());
        }
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Integer id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address = null;
        if (optional.isPresent()){
            address = optional.get();
        }
        else {
            throw new RuntimeException("hotel not found for id:" +id);
        }
        return address;
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
