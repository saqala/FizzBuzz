package com.leboncoin.fizzbuzz.domain;

import com.leboncoin.fizzbuzz.domain.exception.FizzBuzzException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz {

    public static final int LIMIT_MIN = 1;
    private final Integer param1;
    private final Integer param2;
    private final Integer limit;
    private final String str1;
    private final String str2;

    public FizzBuzz(Integer param1, Integer param2, Integer limit, String str1, String str2) {
        validate(param1, param2, limit, str1, str2);
        this.param1 = param1;
        this.param2 = param2;
        this.limit = limit;
        this.str1 = str1;
        this.str2 = str2;
    }

    public List<String> generateTheFizzBuzz() {
        return Stream.iterate(LIMIT_MIN, index -> index <= limit, i -> i + 1).map(this::transformToFizzBuzz).collect(Collectors.toList());

    }

    private String transformToFizzBuzz(Integer value) {
        Integer param3 = param1 * param2;
        return value % param3 == 0 && value >= param3 ? str1.concat(str2) : value % param1 == 0 ? str1 : value % param2 == 0 ? str2 : value.toString();
    }

    private void validate(Integer param1, Integer param2, Integer limit, String str1, String str2) {
        isParamNullOrLessThanOne(param1, param2, limit);
        isStringNullOrEmpty(str1, str2);

    }

    private void isStringNullOrEmpty(String str1, String str2) {
        Stream.of(str1, str2).filter(str -> str == null || str.isEmpty()).findAny().ifPresent(str -> {
            throw FizzBuzzException.create(FizzBuzzException.STRING_NULL_OR_EMPTY);
        });
    }

    private void isParamNullOrLessThanOne(Integer param1, Integer param2, Integer limit) {
        Stream.of(param1, param2, limit).filter(param -> param == null || param < LIMIT_MIN).findAny().ifPresent(param -> {
            throw FizzBuzzException.create(String.format(FizzBuzzException.PARAM_NULL_OR_LESS_THAN_ONE, param));
        });
    }
}
