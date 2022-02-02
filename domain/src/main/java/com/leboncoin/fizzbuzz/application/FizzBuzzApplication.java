package com.leboncoin.fizzbuzz.application;

import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;

public class FizzBuzzApplication {

    private FizzBuzzRepository fizzBuzzPort;

    public FizzBuzzApplication(FizzBuzzRepository fizzBuzzPort) {
        this.fizzBuzzPort = fizzBuzzPort;
    }

    public String getFizzBuzz(){
        return fizzBuzzPort.findParams();
    }

}
