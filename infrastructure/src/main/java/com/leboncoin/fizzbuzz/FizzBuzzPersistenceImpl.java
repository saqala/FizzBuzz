package com.leboncoin.fizzbuzz;

import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;

public class FizzBuzzPersistenceImpl implements FizzBuzzRepository {
    public String findParams() {
        return "params";
    }
}
