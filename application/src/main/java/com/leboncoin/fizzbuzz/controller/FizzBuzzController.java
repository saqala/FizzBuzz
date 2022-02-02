package com.leboncoin.fizzbuzz.controller;

import com.leboncoin.fizzbuzz.application.FizzBuzzApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fizzbuzz")
public class FizzBuzzController {


    final FizzBuzzApplication fizzBuzzApplication;

    public FizzBuzzController(FizzBuzzApplication fizzBuzzApplication) {
        this.fizzBuzzApplication = fizzBuzzApplication;
    }

    @GetMapping("/count-request")
    public ResponseEntity<String> getNumberOfRequests(){
        return ResponseEntity.status(HttpStatus.OK).body(fizzBuzzApplication.getFizzBuzz());
    }

}
