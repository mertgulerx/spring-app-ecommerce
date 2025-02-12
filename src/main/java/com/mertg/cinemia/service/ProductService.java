package com.mertg.cinemia.service;

import com.mertg.cinemia.model.Product;
import com.mertg.cinemia.payload.ProductDTO;
import com.mertg.cinemia.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);

    ProductDTO deleteProduct(Long productId);
}
