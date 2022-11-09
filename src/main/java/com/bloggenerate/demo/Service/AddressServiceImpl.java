package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Address;
import com.bloggenerate.demo.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepo addressRepo;

    @Override
    public Address saveAddress(Address address) {
        addressRepo.save(address);
        return address;
    }
}
