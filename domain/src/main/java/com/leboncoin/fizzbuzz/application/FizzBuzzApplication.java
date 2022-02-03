package com.leboncoin.fizzbuzz.application;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import com.leboncoin.fizzbuzz.domain.exception.FizzBuzzException;
import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;

import java.util.List;

public class FizzBuzzApplication {

    private final FizzBuzzRepository fizzBuzzPort;

    public FizzBuzzApplication(FizzBuzzRepository fizzBuzzPort) {
        this.fizzBuzzPort = fizzBuzzPort;
    }

    public List<String> getFizzBuzz(FizzBuzz fizzBuzz) {
        if (fizzBuzz == null) throw FizzBuzzException.create(FizzBuzzException.NULL_OBJECT);
        fizzBuzzPort.updateCounter(fizzBuzz);
        return fizzBuzz.generateTheFizzBuzz();
    }

    public List<FizzBuzz> findFrequentFizzBuzzes() {
        return fizzBuzzPort.findFrequentFizzBuzzes();
    }

}
