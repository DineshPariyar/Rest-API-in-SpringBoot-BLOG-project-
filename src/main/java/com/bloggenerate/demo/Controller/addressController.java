package com.bloggenerate.demo.Controller;


import com.bloggenerate.demo.Entity.Address;
import com.bloggenerate.demo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addressController {

    @Autowired
    AddressService addressService;


    @PostMapping("/address/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
       Address add = addressService.saveAddress(address);
       return ResponseEntity.status(HttpStatus.OK).body(add);
    }
}
