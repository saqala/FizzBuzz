package com.leboncoin.fizzbuzz;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import com.leboncoin.fizzbuzz.entities.FizzBuzzCounterEntity;
import com.leboncoin.fizzbuzz.mapper.FizzBuzzMapper;
import com.leboncoin.fizzbuzz.repository.FizzBuzzDao;
import com.leboncoin.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FizzBuzzPersistenceImpl implements FizzBuzzRepository {

    @Autowired
    FizzBuzzDao fizzBuzzDao;

    @Override
    public List<FizzBuzz> findFrequentFizzBuzzes() {
        return FizzBuzzMapper.toDomains(fizzBuzzDao.getListOfFrequentFizzBuzzes());
    }

    @Override
    public void updateCounter(FizzBuzz fizzBuzz) {
        Optional<FizzBuzzCounterEntity> optionalEntity = fizzBuzzDao.findByParam1AndParam2AndLimitAndStr1AndStr2(fizzBuzz.getParam1(), fizzBuzz.getParam2(), fizzBuzz.getLimit(), fizzBuzz.getStr1(), fizzBuzz.getStr2());
        FizzBuzzCounterEntity entity = optionalEntity.orElseGet(()-> FizzBuzzMapper.toEntity(fizzBuzz));
        entity.setCounter(entity.getCounter()+1);
        fizzBuzzDao.save(entity);
    }

}
