package com.coffeeshop.model.web.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RichExampleDtoResponse {

    private Long id;
    private String name;
    private String email;
    private Integer price;
    private String imageUrl;
}
