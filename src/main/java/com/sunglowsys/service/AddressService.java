package com.sunglowsys.service;

import com.sunglowsys.domain.Address;

import java.util.List;

public interface AddressService {
    Address createAddrerss(Address address);

    Address update(Address address, Integer id);

    List<Address> findAll();
    Address findById(Integer id);
    void delete(Integer id);
}
