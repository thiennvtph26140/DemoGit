package com.example.demo_java6.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student2 {
    String name;
    Double marks;
    Boolean gender;
    Contact contact;
    List<String> subject;
}
