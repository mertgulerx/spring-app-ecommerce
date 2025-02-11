package com.mertg.cinemia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String productName;
    private String description;
    private Integer quantity;
    private String image;
    private BigDecimal price;

    @Min(0)
    @Max(1)
    private BigDecimal discount;

    private BigDecimal specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
