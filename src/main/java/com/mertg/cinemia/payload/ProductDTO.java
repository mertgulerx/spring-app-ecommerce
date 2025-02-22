package com.mertg.cinemia.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain at least 3 characters")
    private String productName;

    @NotBlank
    @Size(min = 6, message = "Product description must contain at least 6 characters")
    private String description;
    private String image;
    private Integer quantity;
    private BigDecimal price;
    @Min(0)
    @Max(1)
    private BigDecimal discount;
    private BigDecimal specialPrice;
}
