package com.mertguler.ecommerce.service;

import com.mertguler.ecommerce.payload.CartDTO;

public interface CartService {
    CartDTO addProductToCard(Long productId, Integer quantity);
}
