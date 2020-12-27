package com.example.robofinance.repository;

import com.example.robofinance.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    Address findFirstById (Long id);

}
