package com.coffeeshop.converter.converters;

import com.coffeeshop.model.entity.Example;
import com.coffeeshop.model.web.example.ExampleDtoRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExampleDtoRequestToExample implements Converter<ExampleDtoRequest, Example> {

    @Override
    public Example convert(ExampleDtoRequest source) {
        return Example.builder()
                .email(source.getEmail())
                .name(source.getName())
                .imageUrl(source.getImageUrl())
                .price(source.getPrice())
                .build();
    }
}
