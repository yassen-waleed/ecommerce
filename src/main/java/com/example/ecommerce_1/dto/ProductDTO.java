package com.example.ecommerce_1.dto;

import com.example.ecommerce_1.model.Category;
import com.example.ecommerce_1.model.Supplier;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Long id ;
    private String name ;
    private Double price ;
    private Long category_id ;
    private Long supplier_id ;

}
