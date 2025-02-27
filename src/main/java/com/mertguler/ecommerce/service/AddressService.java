package com.mertguler.ecommerce.service;

import com.mertguler.ecommerce.model.User;
import com.mertguler.ecommerce.payload.AddressDTO;
import com.mertguler.ecommerce.payload.AddressResponse;
import jakarta.validation.Valid;

public interface AddressService{
    AddressDTO createAddress(@Valid AddressDTO addressDTO, User user);

    AddressResponse getAllAddresses();

    AddressDTO getAddress(Long addressId);

    AddressResponse getUserAddress(User user);

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);

    AddressDTO deleteAddress(Long addressId);
}
