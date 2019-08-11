package com.coffeeshop.service;

import com.coffeeshop.converter.CommonConverter;
import com.coffeeshop.converter.converters.ExampleDtoRequestToExample;
import com.coffeeshop.converter.converters.ExampleToBaseExampleDtoConverter;
import com.coffeeshop.converter.converters.ExampleToRichExampleDtoConverter;
import com.coffeeshop.model.entity.Example;
import com.coffeeshop.model.web.example.ExampleDtoRequest;
import com.coffeeshop.model.web.example.RichExampleDtoResponse;
import com.coffeeshop.repository.ExampleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTest {

    @Mock
    private ExampleRepository exampleRepository;

    @Mock
    private CommonConverter commonConverter;

    @Spy
    private ExampleToRichExampleDtoConverter exampleToRichExampleDtoConverter;

    @Spy
    private ExampleToBaseExampleDtoConverter exampleToBaseExampleDtoConverter;

    @Spy
    private ExampleDtoRequestToExample exampleDtoRequestToExample;

    @InjectMocks
    private ExampleServiceImpl exampleService;

    private static final ExampleDtoRequest DEFAULT_REQUEST = ExampleDtoRequest.builder()
            .price(100)
            .imageUrl("image_url")
            .email("email@site.com")
            .name("Name")
            .build();

    private static final Example DEFAULT_ENTITY = Example.builder()
            .email(DEFAULT_REQUEST.getEmail())
            .imageUrl(DEFAULT_REQUEST.getImageUrl())
            .name(DEFAULT_REQUEST.getName())
            .price(DEFAULT_REQUEST.getPrice())
            .id(1L)
            .build();

    @Before
    public void setUp() {
        Mockito.when(commonConverter.getExampleDtoRequestToExample()).thenReturn(exampleDtoRequestToExample);

//        Mockito.when(commonConverter.getExampleToBaseExampleDtoConverter())
//                .thenReturn(exampleToBaseExampleDtoConverter);

        Mockito.when(commonConverter.getExampleToRichExampleDtoConverter())
                .thenReturn(exampleToRichExampleDtoConverter);
    }

    @Test
    public void savePositive() {
        Mockito.when(exampleRepository.save(ArgumentMatchers.any(Example.class)))
                .thenReturn(DEFAULT_ENTITY);
        RichExampleDtoResponse response = exampleService.save(DEFAULT_REQUEST);
        Assert.assertEquals(DEFAULT_ENTITY.getEmail(), response.getEmail());
        Assert.assertEquals(DEFAULT_ENTITY.getImageUrl(), response.getImageUrl());
        Assert.assertEquals(DEFAULT_ENTITY.getName(), response.getName());
        Assert.assertEquals(DEFAULT_ENTITY.getPrice(), response.getPrice());
        Assert.assertEquals(DEFAULT_ENTITY.getId(), response.getId());
    }

    @Test
    public void findByIdExistingPositive() {
        Long id = 1L;
        Mockito.when(exampleRepository.findById(ArgumentMatchers.eq(id)))
                .thenReturn(Optional.of(DEFAULT_ENTITY));

        RichExampleDtoResponse response = exampleService.findById(id);
        Assert.assertNotNull(response);
    }

    @Test
    public void findByIdNotExistingNegative() {
        Long id = 1L;
        Mockito.when(exampleRepository.findById(ArgumentMatchers.eq(id)))
                .thenReturn(Optional.empty());

        RichExampleDtoResponse response = exampleService.findById(id);
        Assert.assertNull(response);
    }

    @Test
    public void findByIdNullNegative() {
//        Mockito.when(exampleRepository.findById(ArgumentMatchers.isNull()))
//                .thenThrow(IllegalArgumentException.class);

        RichExampleDtoResponse response = exampleService.findById(null);
        Assert.assertNull(response);
    }

}
