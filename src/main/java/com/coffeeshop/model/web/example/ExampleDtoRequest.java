package com.coffeeshop.model.web.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExampleDtoRequest {

    @NotBlank
    @Length(min = 3, max = 50)
    private String name;

    @NotBlank
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @Min(value = 1)
    @Max(value = 1000)
    @NotNull
    private Integer price;

    @NotBlank
    @Length(max = 200)
    private String imageUrl;
}
