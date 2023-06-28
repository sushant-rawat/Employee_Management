package com.geekster.Employee.service;


import com.geekster.Employee.model.Address;
import com.geekster.Employee.model.Employee;
import com.geekster.Employee.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;

    public List<Address> getAllAddressData() {
        return (List<Address>) addressRepository.findAll();
    }

    public String addAllAddressData(List<Address> addresses) {
        addressRepository.saveAll(addresses);
        return "Address saved successfully";
    }

    public String updateAddressData(int id, Address address) {
        Iterable<Address> addresses=addressRepository.findAll();
        for (Address address1:addresses){
            if(address1.getAddressId()==id){
                address1.setState(address.getState());
                address1.setCity(address.getCity());
                address1.setStreet(address.getStreet());
                address1.setZipcode(address.getZipcode());
            }
        }
        return "Address data updated Successfully";
    }

    public String deleteAddressData(int id) {
        addressRepository.deleteById(id);
        return "Address with id "+id+" has been deleted";
    }
}
