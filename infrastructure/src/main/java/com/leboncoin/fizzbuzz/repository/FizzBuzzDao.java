package com.leboncoin.fizzbuzz.repository;

import com.leboncoin.fizzbuzz.entities.FizzBuzzCounterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FizzBuzzDao extends JpaRepository<FizzBuzzCounterEntity, Integer> {

    Optional<FizzBuzzCounterEntity> findByParam1AndParam2AndLimitAndStr1AndStr2(Integer param1, Integer param2, Integer limit, String str1, String str2);

    @Query("select fb from FizzBuzzCounterEntity fb where fb.counter = (select max(fb.counter) from FizzBuzzCounterEntity fb)")
    List<FizzBuzzCounterEntity> getListOfFrequentFizzBuzzes();

}
