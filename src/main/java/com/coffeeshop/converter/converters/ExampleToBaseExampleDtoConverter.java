package com.coffeeshop.converter.converters;

import com.coffeeshop.model.entity.Example;
import com.coffeeshop.model.web.example.BaseExampleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExampleToBaseExampleDtoConverter implements Converter<Example, BaseExampleDto> {

    @Override
    public BaseExampleDto convert(Example source) {
        return BaseExampleDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

    public List<BaseExampleDto> convertList(List<Example> examples) {
        return examples.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
