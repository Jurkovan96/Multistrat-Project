package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    ModelMapper modelMapper = new ModelMapper();

    public Address getAllByAddressId(Integer addressID) {
        modelMapper.map(addressRepository.findAllByAddressId(addressID), new AddressDto());
        return addressRepository.findAllByAddressId(addressID);
    }



}
