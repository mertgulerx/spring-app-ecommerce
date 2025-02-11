package com.mertg.cinemia.service;

import com.mertg.cinemia.model.Category;
import com.mertg.cinemia.payload.CategoryDTO;
import com.mertg.cinemia.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO category, Long categoryId);
}
