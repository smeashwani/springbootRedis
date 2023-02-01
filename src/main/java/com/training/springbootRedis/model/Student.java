package com.training.springbootRedis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {
  
    public enum Gender { 
        MALE, FEMALE
    }
    private String id;
    private String name;
    private Gender gender;
    private int grade;
}