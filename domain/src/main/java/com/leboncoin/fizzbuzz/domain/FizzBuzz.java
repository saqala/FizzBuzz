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
    private final Integer counter;

    public FizzBuzz(Integer param1, Integer param2, Integer limit, String str1, String str2, Integer counter) {
        validate(param1, param2, limit, str1, str2);
        this.param1 = param1;
        this.param2 = param2;
        this.limit = limit;
        this.str1 = str1;
        this.str2 = str2;
        this.counter = counter;
    }

    public Integer getParam1() {
        return param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public Integer getLimit() {
        return limit;
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    public Integer getCounter() {
        return counter;
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
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
            throw FizzBuzzException.create(FizzBuzzException.STRING_NULL_OR_EMPTY);

    }

    private void isParamNullOrLessThanOne(Integer param1, Integer param2, Integer limit) {
        if (param1 == null || param2 == null || limit == null)
            throw FizzBuzzException.create(FizzBuzzException.PARAM_NULL);
        Stream.of(param1, param2, limit).filter(param -> param < LIMIT_MIN).findAny().ifPresent(param -> {
            throw FizzBuzzException.create(String.format(FizzBuzzException.PARAM_LESS_THAN_ONE, param));
        });
    }

}
