package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class myTeacher {
// ID , name , salary
   @NotNull(message = "Teacher id empty")
    private int id;
    @NotEmpty(message = "Teacher name empty")
    private  String name ;
    @NotNull
    private double salary;


 }





