package com.coffeeshop.converter.converters;

import com.coffeeshop.model.entity.Example;
import com.coffeeshop.model.web.example.RichExampleDtoResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExampleToRichExampleDtoConverter implements Converter<Example, RichExampleDtoResponse> {

    @Override
    public RichExampleDtoResponse convert(Example source) {
        return RichExampleDtoResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .email(source.getEmail())
                .imageUrl(source.getImageUrl())
                .price(source.getPrice())
                .build();
    }

}
