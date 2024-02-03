package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.ecommerce.dto.AddressDTO;
import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.repository.AddressRepository;
@Service
public class AddressServiceImp implements IAddressService {
    @Autowired
    AddressRepository repo;
    
	@Override
	public Address addAddress(AddressDTO addressDTO) {
		
		return null;
	}

	@Override
	public Address updateAddress(AddressDTO addressDTO) {
		
		return null;
	}

	@Override
	public String deleteAddressById(int addressId) {
		
		return null;
	}

	@Override
	public AddressDTO getAddressById(int addressId) {
		
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		return null;
	}

}
