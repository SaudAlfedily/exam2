package com.example.exam2.Controller;


import com.example.exam2.ApiRespnse.ApiResponse;
import com.example.exam2.Model.myTeacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        ArrayList<myTeacher> teachers = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);

    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody myTeacher myTeacher, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isAdded = teacherService.addTeacher(myTeacher);
        if (isAdded) {
            return ResponseEntity.status(200).body("teacher added");

        } else return ResponseEntity.status(400).body("teacher dose not added he is  her before ");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody myTeacher myTeacher, @PathVariable int id, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isUpdated = teacherService.updateTeacher(myTeacher,id);
        if (isUpdated) {
            return ResponseEntity.status(200).body("teacher updated");

        } else return ResponseEntity.status(400).body("teacher not here");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {

        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("teacher deleted");


        } else return ResponseEntity.status(400).body("teacher is not here");


    }
    @PostMapping("get-teacher/{id}")
    public ResponseEntity getOneTeacher(@PathVariable int id ){
   String teacher=teacherService.getOneTeacher(id);

        return ResponseEntity.status(200).body(teacher);


    }

}
