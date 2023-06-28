package com.geekster.Employee.controller;

import com.geekster.Employee.model.Address;
import com.geekster.Employee.model.Employee;
import com.geekster.Employee.service.AddressService;
import com.geekster.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/getAllAddress")
    public List<Address> getALlAddress(){
        return addressService.getAllAddressData();
    }

    @PostMapping(value = "/addAllAddress")
    public String addAllAddress(@RequestBody List<Address> addresses){
        return addressService.addAllAddressData(addresses);
    }

    @PutMapping(value = "/updateAddress/{id}")
    public String updateAddressData(@PathVariable int id, @RequestBody Address address){
        return  addressService.updateAddressData(id,address);
    }

    @DeleteMapping(value = "/deleteAddress/{id}")
    public String deleteAddress(@PathVariable int id){
        return addressService.deleteAddressData(id);
    }
}
