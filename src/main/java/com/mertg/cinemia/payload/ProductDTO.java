package com.mertg.cinemia.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String image;
    private Integer quantity;
    private BigDecimal price;
    @Min(0)
    @Max(1)
    private BigDecimal discount;
    private BigDecimal specialPrice;
}
