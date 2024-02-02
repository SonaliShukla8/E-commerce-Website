package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.Address;

public interface IAddressService {
    public Address addAddress(Address address);
    public Address updateAddress(Address address);
    public String deleteAddressById(int addressId);
    public Address getAddressById(int addressId);
    public List<Address> getAllAddress();
}
