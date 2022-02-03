package com.leboncoin.fizzbuzz.controller;

import com.leboncoin.fizzbuzz.application.FizzBuzzApplication;
import com.leboncoin.fizzbuzz.dto.FizzBuzzDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/fizzbuzz")
public class FizzBuzzController {

    Logger LOGGER = Logger.getLogger(FizzBuzzController.class.getName());

    final FizzBuzzApplication fizzBuzzApplication;

    public FizzBuzzController(FizzBuzzApplication fizzBuzzApplication) {
        this.fizzBuzzApplication = fizzBuzzApplication;
    }

    @PostMapping("")
    public ResponseEntity transformToFizzBuzz(@RequestBody FizzBuzzDto fizzBuzzDto) {
        try {
            ResponseEntity<List<String>> body = ResponseEntity.status(HttpStatus.OK).body(fizzBuzzApplication.getFizzBuzz(FizzBuzzDto.toDomain(fizzBuzzDto)));
            return body;
        } catch (Exception exception) {
            LOGGER.log(Level.WARNING, exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/frequent")
    public ResponseEntity transformToFizzBuzz() {
        return ResponseEntity.status(HttpStatus.OK).body(fizzBuzzApplication.findFrequentFizzBuzzes());
    }

}
