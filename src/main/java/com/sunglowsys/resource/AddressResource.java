package com.sunglowsys.resource;

import com.sunglowsys.domain.Address;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/addresses")
public class AddressResource {

    private final Logger log = LoggerFactory.getLogger(AddressResource.class);

    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/addresses")
    public ResponseEntity<?> createAddress(@RequestBody Address address) throws URISyntaxException {
        log.debug("REST request to create Addresses : {}",address);
        if (address.getId() != null){
            throw new BadRequestException("Id should be null in create api call");
        }
        Address result = addressService.create(address);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses(Pageable pageable){
        log.debug("REST request to getAll Addresses : {}", pageable.toString());
        Page<Address> result = addressService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id){
        log.debug("REST request to get Address : {}",id);
        Optional<Address>result = addressService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@RequestBody Address address, @PathVariable("id") Long id){
        log.debug("REST request to update Address : {}", id);
        Address result = addressService.update(address,id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable("id") Long id){
        log.debug("REST request to delete Address : {}", id);
        addressService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
