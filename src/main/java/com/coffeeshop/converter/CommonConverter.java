package com.coffeeshop.converter;

import com.coffeeshop.converter.converters.ExampleDtoRequestToExample;
import com.coffeeshop.converter.converters.ExampleToBaseExampleDtoConverter;
import com.coffeeshop.converter.converters.ExampleToRichExampleDtoConverter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CommonConverter {

    private ExampleToRichExampleDtoConverter exampleToRichExampleDtoConverter;
    private ExampleToBaseExampleDtoConverter exampleToBaseExampleDtoConverter;
    private ExampleDtoRequestToExample exampleDtoRequestToExample;

    @Autowired
    public CommonConverter(ExampleToRichExampleDtoConverter exampleToRichExampleDtoConverter, ExampleToBaseExampleDtoConverter exampleToBaseExampleDtoConverter, ExampleDtoRequestToExample exampleDtoRequestToExample) {
        this.exampleToRichExampleDtoConverter = exampleToRichExampleDtoConverter;
        this.exampleToBaseExampleDtoConverter = exampleToBaseExampleDtoConverter;
        this.exampleDtoRequestToExample = exampleDtoRequestToExample;
    }
}
