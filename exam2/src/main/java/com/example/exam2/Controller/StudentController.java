package com.example.exam2.Controller;

import com.example.exam2.ApiRespnse.ApiResponse;
import com.example.exam2.Model.myStudent;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<myStudent> students = studentService.getStudent();
        return ResponseEntity.status(200).body(students);

    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody myStudent myStudent, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isAdded = studentService.addStudent(myStudent);
        if (isAdded) {
            return ResponseEntity.status(200).body("student added");

        } else return ResponseEntity.status(400).body("student dose not added he is  her before ");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody myStudent myStudent, @PathVariable int id, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isUpdated = studentService.updateStudent(myStudent, id);
        if (isUpdated) {
            return ResponseEntity.status(200).body("student updated");

        } else return ResponseEntity.status(400).body("student not here");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {

        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("student deleted");


        } else return ResponseEntity.status(400).body("student is not here");


    }
    @PostMapping("get-student")
    public ResponseEntity getOneTeacher(@RequestBody  String name  ){
        String students=studentService.getOneStudent(name);

        return ResponseEntity.status(200).body(students);


    }


}
