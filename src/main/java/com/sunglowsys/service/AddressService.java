package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AddressService {

    Address create(Address address);

    Address update(Address address, Long id);

    Page<Address> findAll(Pageable pageable);

    Optional<Address> findById(Long id);

    void delete(Long id);
}
