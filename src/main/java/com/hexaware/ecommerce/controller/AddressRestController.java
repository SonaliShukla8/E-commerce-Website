package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.AddressDTO;
import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressRestController {

	@Autowired
	IAddressService service;

	@PostMapping("/add")
	public Address addAddress(@RequestBody @Valid AddressDTO addressDTO) {

		return service.addAddress(addressDTO);
	}
	
	@PutMapping("/update")
	public Address updateAddress(@RequestBody @Valid AddressDTO addressDTO) {

		return service.updateAddress(addressDTO);
	}
	
	@DeleteMapping("/delete/{addressId}")
	public String deleteAddressById(@PathVariable int addressId) {

		return service.deleteAddressById(addressId);
	}
	
	@GetMapping("/getbyId/{addressId}")
	public AddressDTO getAddressById(@PathVariable int addressId) {

		return service.getAddressById(addressId);
	}
	
	@GetMapping("/getall")
	public List<Address> getAllAddress() {

		return service.getAllAddress();
	}

}
