package com.mertg.cinemia.service;

import com.mertg.cinemia.exceptions.ResourceNotFoundException;
import com.mertg.cinemia.model.Category;
import com.mertg.cinemia.model.Product;
import com.mertg.cinemia.payload.ProductDTO;
import com.mertg.cinemia.repositories.CategoryRepository;
import com.mertg.cinemia.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        product.setImage("default.png");
        product.setCategory(category);
        BigDecimal specialPrice = product.getPrice().multiply(BigDecimal.valueOf(1).subtract(product.getDiscount()));
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
