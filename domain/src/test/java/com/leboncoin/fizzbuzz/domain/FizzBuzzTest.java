package com.leboncoin.fizzbuzz.domain;

import com.leboncoin.fizzbuzz.domain.exception.FizzBuzzException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzTest {

    Integer param1 = 3;
    Integer param2 = 5;
    Integer limit = 100;
    String str1 = "FIZZ";
    String str2 = "BUZZ";

    @Test
    void create_fizzbuzz_with_param1_null_throw_exception() {
        FizzBuzzException thrown = assertThrows(FizzBuzzException.class, () -> new FizzBuzz(null, param2, limit, str1, str2, null));
        assertEquals(FizzBuzzException.PARAM_NULL, thrown.getMessage());
    }

    @Test
    void create_fizzbuzz_with_param2_less_than_1_throw_exception() {
        param2 = 0;
        FizzBuzzException thrown = assertThrows(FizzBuzzException.class, () -> new FizzBuzz(param1, param2, limit, str1, str2, null));
        assertEquals(String.format(FizzBuzzException.PARAM_LESS_THAN_ONE, param2), thrown.getMessage());
    }

    @Test
    void create_fizzbuzz_with_str1_null() {
        FizzBuzzException thrown = assertThrows(FizzBuzzException.class, () -> new FizzBuzz(param1, param2, limit, null, str2, null));
        assertEquals(String.format(FizzBuzzException.STRING_NULL_OR_EMPTY, param2), thrown.getMessage());
    }

    @Test
    void create_fizzbuzz_with_right_params() {
        FizzBuzz fizzBuzz = new FizzBuzz(param1, param2, limit, str1, str2, null);
        List<String> result = fizzBuzz.generateTheFizzBuzz();
        assertNotNull(result);
        assertEquals(result.size(), limit.intValue());
        assertEquals(result.get(2), str1);
        assertEquals(result.get(4), str2);
        assertEquals(result.get(5), str1);
        assertEquals(result.get(9), str2);
        assertEquals(result.get(14), str1 + str2);
        assertEquals(result.get(29), str1 + str2);
    }

    @Test
    void create_fizzbuzz_with_all_params_equal_1() {
        param1 = 1;
        param2 = 1;
        limit = 1;
        FizzBuzz fizzBuzz = new FizzBuzz(param1, param2, limit, str1, str2, null);
        List<String> result = fizzBuzz.generateTheFizzBuzz();
        assertNotNull(result);
        assertEquals(result.size(), limit.intValue());
        assertEquals(result.get(0), str1 + str2);
    }
}
