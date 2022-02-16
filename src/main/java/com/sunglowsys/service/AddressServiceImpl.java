package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    private  final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address create(Address address) {
        log.debug("Request to create Address : {}",address);
        return addressRepository.save(address);
    }

    @Override
    public Address update(@RequestBody Address address, Long id) {

        return addressRepository.save(address);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        log.debug("Request to findAll Addresses : {}", pageable.toString());
        return addressRepository.findAll(pageable);
    }

    @Override
    public Optional<Address> findById(Long id) {
        log.debug("Request to get Address : {}",id);
        return addressRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Address : {}", id);
        addressRepository.deleteById(id);
    }
}
