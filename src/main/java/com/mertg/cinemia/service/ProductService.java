package com.mertg.cinemia.service;

import com.mertg.cinemia.model.Product;
import com.mertg.cinemia.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
