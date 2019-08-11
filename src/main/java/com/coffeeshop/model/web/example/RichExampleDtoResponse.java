package com.coffeeshop.model.web.example;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RichExampleDtoResponse {

    private Long id;
    private String name;
    private String email;
    private Integer price;
    private String imageUrl;
}
