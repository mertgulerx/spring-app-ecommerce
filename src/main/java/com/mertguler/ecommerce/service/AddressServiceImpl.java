package com.mertguler.ecommerce.service;

import com.mertguler.ecommerce.exceptions.ResourceNotFoundException;
import com.mertguler.ecommerce.model.Address;
import com.mertguler.ecommerce.model.User;
import com.mertguler.ecommerce.payload.AddressDTO;
import com.mertguler.ecommerce.payload.AddressResponse;
import com.mertguler.ecommerce.repositories.AddressRepository;
import com.mertguler.ecommerce.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);
        List<Address> addressList = user.getAddresses();

        addressList.add(address);
        user.setAddresses(addressList);
        address.setUser(user);
        return modelMapper.map(addressRepository.save(address), AddressDTO.class);
    }

    @Override
    public AddressResponse getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();

        List<AddressDTO> addressDTOS = addresses.stream().
                map(address -> modelMapper.map(address, AddressDTO.class)).
                toList();

        return new AddressResponse(addressDTOS);
    }

    @Override
    public AddressDTO getAddress(Long addressId) {
        Address address = addressRepository.findById(addressId).
                orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public AddressResponse getUserAddress(User user) {
        List<Address> addresses = user.getAddresses();

        List<AddressDTO> addressDTOS = addresses.stream().
                map(address -> modelMapper.map(address, AddressDTO.class)).
                toList();

        return new AddressResponse(addressDTOS);
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
        Address addressFromDb = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

        Address address = modelMapper.map(addressDTO, Address.class);
        address.setAddressId(addressId);
        address.setUser(addressFromDb.getUser());

        addressRepository.save(address);

//        addressFromDatabase.setCity(addressDTO.getCity());
//        addressFromDatabase.setPincode(addressDTO.getPincode());
//        addressFromDatabase.setState(addressDTO.getState());
//        addressFromDatabase.setCountry(addressDTO.getCountry());
//        addressFromDatabase.setStreet(addressDTO.getStreet());
//        addressFromDatabase.setBuildingName(addressDTO.getBuildingName());
//
//        Address updatedAddress = addressRepository.save(addressFromDatabase);
//
//        User user = addressFromDatabase.getUser();
//        user.getAddresses().removeIf(address -> address.getAddressId().equals(addressId));
//        user.getAddresses().add(updatedAddress);
//        userRepository.save(user);
//
//        return modelMapper.map(updatedAddress, AddressDTO.class);

        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public AddressDTO deleteAddress(Long addressId) {
        Address addressFromDb = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
        User user = addressFromDb.getUser();
        List<Address> addressList = user.getAddresses();
        addressList.remove(addressFromDb);
        user.setAddresses(addressList);
        userRepository.save(user);
        addressRepository.delete(addressFromDb);

//        User user = addressFromDatabase.getUser();
//        user.getAddresses().removeIf(address -> address.getAddressId().equals(addressId));
//        userRepository.save(user);
//
//        addressRepository.delete(addressFromDatabase);
//
//        return "Address deleted successfully with addressId: " + addressId;

        return modelMapper.map(addressFromDb, AddressDTO.class);
    }
}
