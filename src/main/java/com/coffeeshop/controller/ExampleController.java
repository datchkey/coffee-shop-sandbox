package com.coffeeshop.controller;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.web.example.BaseExampleDto;
import com.coffeeshop.model.web.example.ExampleDtoRequest;
import com.coffeeshop.model.web.example.RichExampleDtoResponse;
import com.coffeeshop.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/examples")
    public List<BaseExampleDto> getExamples() {

        return exampleService.findAll();
    }

    @PostMapping("/examples")
    public RichExampleDtoResponse save(@RequestBody @Valid ExampleDtoRequest exampleDtoRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }

        return exampleService.save(exampleDtoRequest);
    }

    @GetMapping("/examples/{id}")
    public RichExampleDtoResponse getById(@PathVariable("id") Long id) {
        return exampleService.findById(id);
    }

}
