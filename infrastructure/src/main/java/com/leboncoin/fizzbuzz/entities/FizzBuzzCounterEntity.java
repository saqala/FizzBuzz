package com.leboncoin.fizzbuzz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fizz_buzz_counter")
public class FizzBuzzCounterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer param1;
    private Integer param2;
    @Column(name = "limit_")
    private Integer limit;
    private String str1;
    private String str2;
    private Integer counter;
    @Version
    private Long version;
}
