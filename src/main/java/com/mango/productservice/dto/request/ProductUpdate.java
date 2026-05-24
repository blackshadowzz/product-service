package com.mango.productservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdate {

    @NotBlank(message = "Product name is required")
    private String productName;

    private String Description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @PositiveOrZero(message = "Discount must be zero or positive")
    private Double discount;

    private boolean deleted ;
}
