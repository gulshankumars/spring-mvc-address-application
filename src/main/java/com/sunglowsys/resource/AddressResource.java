package com.sunglowsys.resource;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/addresses")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address){
        Address result = addressService.createAddrerss(address);
        return ResponseEntity.ok().body("Address is created successfully: " + result);
    }

    @GetMapping("/find_all_addresses")
    public List<Address> getAll(){
        List<Address> result1 = addressService.findAll();
        return result1;
    }

    @GetMapping("find_address/{id}")
    public Address getById(@PathVariable("id") Integer id){
        return addressService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Address address, @PathVariable("id") Integer id){
        addressService.update(address, id);
        return ResponseEntity.ok().body("Address is updated successfully: " + id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        addressService.delete(id);
        return ResponseEntity.ok().body("Address is successfully Deleted on this ID: " + id);
    }
}
