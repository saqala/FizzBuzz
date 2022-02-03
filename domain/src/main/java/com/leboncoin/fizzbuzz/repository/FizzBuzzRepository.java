package com.leboncoin.fizzbuzz.repository;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;

import java.util.List;

public interface FizzBuzzRepository {

    List<FizzBuzz> findFrequentFizzBuzzes();

    void updateCounter(FizzBuzz fizzBuzz);
}
