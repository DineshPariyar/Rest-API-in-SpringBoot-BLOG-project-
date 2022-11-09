package com.bloggenerate.demo.Repository;

import com.bloggenerate.demo.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
