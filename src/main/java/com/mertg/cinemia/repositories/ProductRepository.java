package com.mertg.cinemia.repositories;

import com.mertg.cinemia.model.Category;
import com.mertg.cinemia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);
}
