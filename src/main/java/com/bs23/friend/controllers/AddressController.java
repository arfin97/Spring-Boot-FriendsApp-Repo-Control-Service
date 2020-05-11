package com.bs23.friend.controllers;

import com.bs23.friend.models.Address;
import com.bs23.friend.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping
    public List<Address> findAllAddress(){
        return addressRepo.findAll();
    }
}
