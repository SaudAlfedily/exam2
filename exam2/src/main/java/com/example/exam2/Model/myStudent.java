package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class myStudent {

  @NotNull(message = "id empty")//if int not null
    private int id;  // ID , name , age , major
    @NotEmpty(message = "name empty")
    private String name;
    @NotNull(message = "age empty ")
    private int age;
    @NotEmpty(message = "major empty")
    private String major;


}
