package com.tural.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

}
