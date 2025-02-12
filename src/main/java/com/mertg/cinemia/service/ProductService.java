package com.mertg.cinemia.service;

import com.mertg.cinemia.payload.ProductDTO;
import com.mertg.cinemia.payload.ProductResponse;
import jakarta.validation.Valid;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, @Valid ProductDTO product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProduct(Long productId);
}
