package com.coffeeshop.service;

import com.coffeeshop.model.web.example.BaseExampleDto;
import com.coffeeshop.model.web.example.ExampleDtoRequest;
import com.coffeeshop.model.web.example.RichExampleDtoResponse;

import java.util.List;

public interface ExampleService {

    RichExampleDtoResponse save(ExampleDtoRequest request);
    List<BaseExampleDto> findAll();
    RichExampleDtoResponse findById(Long id);
}
