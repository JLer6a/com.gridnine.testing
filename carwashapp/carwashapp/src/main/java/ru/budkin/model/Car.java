package ru.budkin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    private Integer id;
    private Integer number;
    private String time;
    private String service;
    // private ServiceImpl serviceWork;






}
