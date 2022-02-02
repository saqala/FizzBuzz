package com.leboncoin.fizzbuzz.context;

import com.leboncoin.fizzbuzz.FizzBuzzPersistenceImpl;
import com.leboncoin.fizzbuzz.application.FizzBuzzApplication;
import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzContext {

    @Bean
    public FizzBuzzRepository fizzBuzzRepository() {
        return new FizzBuzzPersistenceImpl();
    }

    @Bean
    public FizzBuzzApplication fizzBuzzApplication(FizzBuzzRepository fizzBuzzRepository) {
        return new FizzBuzzApplication(fizzBuzzRepository);
    }

}
