package com.coffeeshop.service;

import com.coffeeshop.converter.CommonConverter;
import com.coffeeshop.model.entity.Example;
import com.coffeeshop.model.web.example.BaseExampleDto;
import com.coffeeshop.model.web.example.ExampleDtoRequest;
import com.coffeeshop.model.web.example.RichExampleDtoResponse;
import com.coffeeshop.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private CommonConverter commonConverter;

    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public RichExampleDtoResponse save(ExampleDtoRequest request) {
        Example example = commonConverter.getExampleDtoRequestToExample().convert(request);
        example = exampleRepository.save(example);
        return commonConverter.getExampleToRichExampleDtoConverter().convert(example);
    }

    @Override
    public List<BaseExampleDto> findAll() {
        List<Example> examples = exampleRepository.findAll();

        return commonConverter.getExampleToBaseExampleDtoConverter().convertList(examples);
    }

    @Override
    public RichExampleDtoResponse findById(Long id) {
        if (id == null) {
            return null;
        }
        Example example = exampleRepository.findById(id).orElse(null);
        if (example == null) {
            return null;
        }
        return commonConverter.getExampleToRichExampleDtoConverter().convert(example);
    }
}
