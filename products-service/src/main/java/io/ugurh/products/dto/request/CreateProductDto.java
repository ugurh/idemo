package io.ugurh.products.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    private  String productId;
    private  String title;
    private  BigDecimal price;
    private  Integer quantity;
}
