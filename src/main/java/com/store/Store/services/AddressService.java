package com.store.Store.services;

import com.store.Store.model.Address;
import com.store.Store.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    private MySqlRepository mySqlRepository;

    @Autowired
    public AddressService(MySqlRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }

    public Address getAddressById(int id) {
        return mySqlRepository.findById(id).get();
    }

    public List<Address> getAddressesByIds(int[] ids) {
        return mySqlRepository.findByIdIn(ids);
    }


    public List<Address> getAddresses() {
        return mySqlRepository.findAllWithCity();
    }


}
