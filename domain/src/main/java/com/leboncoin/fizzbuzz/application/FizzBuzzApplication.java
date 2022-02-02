package com.leboncoin.fizzbuzz.application;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import com.leboncoin.fizzbuzz.domain.exception.FizzBuzzException;
import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;

import java.util.List;

public class FizzBuzzApplication {

    private FizzBuzzRepository fizzBuzzPort;

    public FizzBuzzApplication(FizzBuzzRepository fizzBuzzPort) {
        this.fizzBuzzPort = fizzBuzzPort;
    }

    public List<String> getFizzBuzz(FizzBuzz fizzBuzz) {
        if (fizzBuzz == null) throw FizzBuzzException.create(FizzBuzzException.NULL_OBJECT);
        return fizzBuzz.generateTheFizzBuzz();
    }

}
