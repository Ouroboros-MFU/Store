package com.store.Store.controllers;

import com.store.Store.model.Address;
import com.store.Store.repository.MySqlRepository;
import com.store.Store.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {


    private AddressService addressService;

    @Autowired
    public StoreController(AddressService addressService) {
        this.addressService = addressService;
    }
    // сделать возврат массива индексов (не обязательный параметр) int[9,10]
    @GetMapping("/get-all-addresses")
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/get-address/{identity}")
    //@RequestParam(value = "dev", required = false) DeviceType deviceType // пример не обязательного параметра
    public Address getSingleAddress(@PathVariable("identity") Integer id) {
        return addressService.getAddressById(id);
    }

    @GetMapping("/get-addresses")
    public List<Address> getAddressesByIds(@RequestParam int[] ids) {
        return addressService.getAddressesByIds(ids);
    }
}
