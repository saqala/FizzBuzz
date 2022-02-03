package com.leboncoin.fizzbuzz.application;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class FizzBuzzApplicationTest {

    FizzBuzzRepository fizzBuzzRepository;
    FizzBuzzApplication fizzBuzzApplication;

    Integer param1 = 3;
    Integer param2 = 5;
    Integer limit = 100;
    String str1 = "FIZZ";
    String str2 = "BUZZ";
    FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup(){
        fizzBuzz = new FizzBuzz(param1, param2, limit, str1, str2, null);
        fizzBuzzRepository = Mockito.mock(FizzBuzzRepository.class);
        when(fizzBuzzRepository.findFrequentFizzBuzzes()).thenReturn(List.of(fizzBuzz));
        doNothing().when(fizzBuzzRepository).updateCounter(any());
        fizzBuzzApplication = new FizzBuzzApplication(fizzBuzzRepository);
    }

    @Test
    void find_frequent_fizz_buzzes_return_one_element() {

        List<FizzBuzz> result = fizzBuzzApplication.findFrequentFizzBuzzes();
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), fizzBuzz);
    }

    @Test
    void get_fizz_buzzes_return_one_list_of_elements() {

        List<String> result = fizzBuzzApplication.getFizzBuzz(fizzBuzz);
        assertNotNull(result);
        assertEquals(result.size(), limit.intValue());
        assertEquals(result.get(2), str1);
        assertEquals(result.get(4), str2);
        assertEquals(result.get(5), str1);
        assertEquals(result.get(9), str2);
        assertEquals(result.get(14), str1 + str2);
        assertEquals(result.get(29), str1 + str2);
    }
}
