package com.mertguler.ecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long cartId;
    private BigDecimal totalPrice = new BigDecimal("0.0");
    private List<ProductDTO> products = new ArrayList<>();
}
