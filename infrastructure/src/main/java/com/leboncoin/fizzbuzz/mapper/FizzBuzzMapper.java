package com.leboncoin.fizzbuzz.mapper;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import com.leboncoin.fizzbuzz.entities.FizzBuzzCounterEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface FizzBuzzMapper {


    static FizzBuzz toDomain(FizzBuzzCounterEntity entity) {
        if (entity == null) return null;
        return new FizzBuzz(entity.getParam1(), entity.getParam2(), entity.getLimit(), entity.getStr1(), entity.getStr2(), entity.getCounter());
    }

    static List<FizzBuzz> toDomains(List<FizzBuzzCounterEntity> entities) {
        return CollectionUtils.isEmpty(entities) ? Collections.emptyList() : entities.stream().map(FizzBuzzMapper::toDomain).collect(Collectors.toList());
    }

    static FizzBuzzCounterEntity toEntity(FizzBuzz domain) {
        if (domain == null) return null;
        return new FizzBuzzCounterEntity(null, domain.getParam1(), domain.getParam2(), domain.getLimit(), domain.getStr1(), domain.getStr2(), domain.getCounter(), null);
    }
}
