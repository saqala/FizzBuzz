package com.leboncoin.fizzbuzz.dto;

import com.leboncoin.fizzbuzz.domain.FizzBuzz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzzDto {

    private Integer param1;
    private Integer param2;
    private Integer limit;
    private String str1;
    private String str2;

    public static FizzBuzz toDomain(FizzBuzzDto dto) {
        if (dto == null) {
            return null;
        }
        return new FizzBuzz(dto.param1, dto.param2, dto.limit, dto.str1, dto.str2, 0);
    }

}
