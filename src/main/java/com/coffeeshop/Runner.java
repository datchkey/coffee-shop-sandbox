package com.coffeeshop;

import com.coffeeshop.model.entity.Example;
import com.coffeeshop.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ExampleRepository exampleRepository;


    @Override
    public void run(String... args) throws Exception {
        exampleRepository.saveAll(
                Stream.of(Example.builder()
                                .name("Sarah")
                                .email("sarah@site.com")
                                .price(100)
                                .imageUrl("https://www.baeldung.com/wp-content/uploads/2016/05/baeldung-rest-lightbox-main-1.2.0.jpg")
                                .build(),
                        Example.builder()
                                .name("David")
                                .email("david@site.com")
                                .price(1000)
                                .imageUrl("https://www.baeldung.com/wp-content/uploads/2016/05/baeldung-rest-lightbox-main-1.2.0.jpg")
                                .build()
                )
                        .collect(Collectors.toList()));
    }
}
