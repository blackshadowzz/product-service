package com.mango.productservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private int id;

    @NotBlank(message = "Product name is required")
    private String productName;

    private String Description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @PositiveOrZero(message = "Discount must be zero or positive")
    private Double discount;
}
