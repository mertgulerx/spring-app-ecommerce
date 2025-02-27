package com.mertguler.ecommerce.controller;

import com.mertguler.ecommerce.config.AppConstants;
import com.mertguler.ecommerce.model.User;
import com.mertguler.ecommerce.payload.AddressDTO;
import com.mertguler.ecommerce.payload.AddressResponse;
import com.mertguler.ecommerce.payload.CategoryDTO;
import com.mertguler.ecommerce.payload.CategoryResponse;
import com.mertguler.ecommerce.service.AddressService;
import com.mertguler.ecommerce.service.CategoryService;
import com.mertguler.ecommerce.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AuthUtil authUtil;

   @GetMapping("/addresses")
  public ResponseEntity<AddressResponse> getAllAddresses(){
       AddressResponse addressResponse = addressService.getAllAddresses();
      return new ResponseEntity<>(addressResponse, HttpStatus.OK);
   }

   @GetMapping("/addresses/{addressId}")
  public ResponseEntity<AddressDTO> getAddress(@PathVariable Long addressId){
       AddressDTO addressDTO = addressService.getAddress(addressId);
      return new ResponseEntity<>(addressDTO, HttpStatus.OK);
   }

   @PutMapping("/addresses/{addressId}")
  public ResponseEntity<AddressDTO> updateAddressById(@PathVariable Long addressId, @RequestBody AddressDTO addressDTO){
       AddressDTO savedAddressDTO = addressService.updateAddress(addressId, addressDTO);
      return new ResponseEntity<>(savedAddressDTO, HttpStatus.OK);
   }

   @DeleteMapping("/addresses/{addressId}")
  public ResponseEntity<AddressDTO> deleteAddress(@PathVariable Long addressId){
       AddressDTO deleteAddress = addressService.deleteAddress(addressId);
      return new ResponseEntity<>(deleteAddress, HttpStatus.OK);
   }

   @GetMapping("/users/addresses")
  public ResponseEntity<AddressResponse> getUserAddress(){
       User user = authUtil.loggedInUser();
       AddressResponse addressResponse = addressService.getUserAddress(user);
      return new ResponseEntity<>(addressResponse, HttpStatus.OK);
   }

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO =  addressService.createAddress(addressDTO, user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }






}
